package view.panels;

import controller.SelfTestController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Categorie;

public class QuestionDetailPane extends GridPane {
	private Button btnOK, btnCancel;
	private TextArea statementsArea;
	private TextField questionField, statementField, feedbackField;
	private Button btnAdd, btnRemove;
	private ComboBox categoryField;
	private SelfTestController controller;
	private Stage primaryStage;
	private Scene scene;
	private int counter = 0;



	public QuestionDetailPane(SelfTestController controller) {
		scene = new Scene(this,240,240);
		primaryStage = new Stage();
		setController(controller);
		this.setPrefHeight(300);
		this.setPrefWidth(320);
		
		this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);
        
		add(new Label("Question: "), 0, 0, 1, 1);
		questionField = new TextField();
		add(questionField, 1, 0, 2, 1);
		
		add(new Label("Statement: "), 0, 1, 1, 1);
		statementField = new TextField();
		add(statementField, 1, 1, 2, 1);

		add(new Label("Statements: "), 0, 2, 1, 1);
		statementsArea = new TextArea();
		statementsArea.setPrefRowCount(5);
		statementsArea.setEditable(false);
		add(statementsArea, 1, 2, 2, 5);

		Pane addRemove = new HBox();
		btnAdd = new Button("add");
		btnAdd.setOnAction(event -> addAntwoord());
		btnAdd.setOnAction(new AddStatementListener());
		addRemove.getChildren().add(btnAdd);

		btnRemove = new Button("remove");
		btnRemove.setOnAction(new RemoveStatementListener());
		addRemove.getChildren().add(btnRemove);
		add(addRemove, 1, 8, 2, 1);

		add(new Label("Category: "), 0, 9, 1, 1);
		categoryField = new ComboBox();
		add(categoryField, 1, 9, 2, 1);
		categoryField.setItems(controller.getAllCategories());

		add(new Label("Feedback: "), 0, 10, 1, 1);
		feedbackField = new TextField();
		add(feedbackField, 1, 10, 2, 1);

		btnCancel = new Button("Cancel");
		btnCancel.setText("Cancel");
		add(btnCancel, 0, 11, 1, 1);
		btnCancel.setOnAction(event -> this.primaryStage.close());

		btnOK = new Button("Save");
		btnOK.isDefaultButton();
		btnOK.setText("Save");
		add(btnOK, 1, 11, 2, 1);
		btnOK.setOnAction(event -> addQuestionToDatabase(questionField.getText(),feedbackField.getText(),categoryField.getValue()));



		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	private void addAntwoord() {
		if (counter == 0){
			controller.addCorrectAntwoord(statementField.getText());
			statementsArea.appendText(statementField.getText());
			counter += 1;

		}
		else{
			controller.addCorrectAntwoord(statementField.getText());
			statementsArea.appendText(statementField.getText());
			controller.addMogelijkAntwoord(statementField.getText());
			counter+=1;
		}
	}

	private void addQuestionToDatabase(String text, String text1, Object value) {
		getController().addQuestionToDatabase(text,text1,(Categorie)value);
		primaryStage.close();
	}

	public void setSaveAction(EventHandler<ActionEvent> saveAction) {
		btnOK.setOnAction(saveAction);
	}

	public SelfTestController getController() {
		return controller;
	}

	public void setController(SelfTestController controller) {
		this.controller = controller;
	}

	public void setCancelAction(EventHandler<ActionEvent> cancelAction) {
		btnCancel.setOnAction(cancelAction);
	}

	class AddStatementListener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
		}
	}

	class RemoveStatementListener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
		}
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
}
