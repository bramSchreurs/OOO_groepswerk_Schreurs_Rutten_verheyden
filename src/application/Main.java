package application;

import controller.SelfTestController;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Vraag;
import model.databank.DatabaseWithtxt;
import view.panels.AssesMainPane;
import view.panels.CategoryDetailPane;
import view.panels.CategoryOverviewPane;
import view.panels.MessagePane;
import view.panels.QuestionDetailPane;
import view.panels.QuestionOverviewPane;
import view.panels.TestPane;

import java.util.List;

public class Main  extends Application{
	@Override
	public void start(Stage primaryStage) {

		try {//kaas
			//camembert

			SelfTestController controller = new SelfTestController(new DatabaseWithtxt());
			QuestionOverviewPane questionOverviewPane = new QuestionOverviewPane(controller);


			CategoryOverviewPane categoryOverviewPanel = new CategoryOverviewPane(controller);



			MessagePane messagePane = new MessagePane(new Stage(),controller);



			AssesMainPane assesMainPane = new AssesMainPane(controller,messagePane, categoryOverviewPanel, questionOverviewPane);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
