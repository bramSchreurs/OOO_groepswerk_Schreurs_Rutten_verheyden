package view.panels;

import controller.SelfTestController;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Observer;


public class AssesMainPane extends BorderPane implements Observer {
    Stage primaryStage;

	public AssesMainPane(SelfTestController controller,Pane messagePane, Pane categoryOverviewPanel, Pane questionOverviewPanel){
        controller.addObserver(this);
	    primaryStage = new Stage();
        Group root = new Group();
        Scene scene = new Scene(root, 750, 400);
        BorderPane borderPane = this;
        borderPane.prefHeightProperty().bind(scene.heightProperty());
        borderPane.prefWidthProperty().bind(scene.widthProperty());



        root.getChildren().add(borderPane);
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();


        primaryStage.show();
                TabPane tabPane = new TabPane();
	    
	    FlowPane messageBox = new FlowPane(messagePane);
        	messageBox.setAlignment(Pos.CENTER);
        Tab testTab = new Tab("Test", messageBox);
        Tab categoriesTab = new Tab("Categories", categoryOverviewPanel);
        Tab questionsTab = new Tab("Questions", questionOverviewPanel);
        tabPane.getTabs().add(testTab);
        tabPane.getTabs().add(categoriesTab);
        tabPane.getTabs().add(questionsTab);

	    this.setCenter(tabPane);
	}

    @Override
    public void update() {
	    primaryStage.hide();
        primaryStage.close();
    }
}
