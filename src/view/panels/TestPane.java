package view.panels;

import java.util.ArrayList;
import java.util.List;

import controller.SelfTestController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.databank.DatabaseWithtxt;

public class TestPane extends GridPane {
	private Label questionField;
	private Button submitButton;
	private ToggleGroup statementGroup;
	private SelfTestController selfTestController;
	private Stage testStage;
	private int rowCounter;
	private Scene testScene;
	public TestPane (SelfTestController controller){
		rowCounter = 1;
		selfTestController = controller;

		testStage = new Stage();
		this.setPrefHeight(300);
		this.setPrefWidth(750);
		
		this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

		questionField = new Label();
		add(questionField, 0, 0, 1, 1);
		questionField.setText(selfTestController.getNextQuestionString());

		
		statementGroup = new ToggleGroup();
		for (String antwoord:selfTestController.getAlleAntwoorden()) {
			 RadioButton radioButton = new RadioButton(antwoord);
			 radioButton.setUserData(antwoord);
			 radioButton.setToggleGroup(statementGroup);
			 add(radioButton,1,rowCounter,1,1);
			 rowCounter += 1;

		}

		this.submitButton = new Button("Submit");
		add(submitButton,0,rowCounter,1,1);
		submitButton.setOnAction(event -> submitAnswer());
		testScene = new Scene(this,750,300);

		testStage.setScene(testScene);
		testStage.show();
	}

	private void submitAnswer() {
		selfTestController.submitAnswer(getSelectedStatements());
		selfTestController.raiseCounter();
		System.out.println(selfTestController.getCounter());
		if (selfTestController.getNextQuestionString() != null) {

			System.out.println(selfTestController.getCounter());
			new TestPane(selfTestController);
			testStage.close();
		}
		else{
			selfTestController.setCounter(0);
			selfTestController.notifyObservers();
			System.out.println(selfTestController.getCounter());
			Stage primaryStage = new Stage();
			QuestionOverviewPane questionOverviewPane = new QuestionOverviewPane(selfTestController);


			CategoryOverviewPane categoryOverviewPanel = new CategoryOverviewPane(selfTestController);



			MessagePane messagePane = new MessagePane(testStage,selfTestController);

			Group root = new Group();
			Scene scene = new Scene(root, 750, 400);

			BorderPane borderPane = new AssesMainPane(selfTestController,messagePane, categoryOverviewPanel, questionOverviewPane);
			borderPane.prefHeightProperty().bind(scene.heightProperty());
			borderPane.prefWidthProperty().bind(scene.widthProperty());

			root.getChildren().add(borderPane);
			primaryStage.setScene(scene);
			primaryStage.sizeToScene();

			primaryStage.show();
			testStage.close();
		}

	}

	public void setProcessAnswerAction(EventHandler<ActionEvent> processAnswerAction) {
		submitButton.setOnAction(processAnswerAction);
	}

	public List<String> getSelectedStatements() {
		 List<String> selected = new ArrayList<String>();
		if(statementGroup.getSelectedToggle()!=null){
			selected.add(statementGroup.getSelectedToggle().getUserData().toString());
		}
		return selected;
	}

	public SelfTestController getSelfTestController() {
		return selfTestController;
	}

	public void setSelfTestController(SelfTestController selfTestController) {
		this.selfTestController = selfTestController;
	}
}
