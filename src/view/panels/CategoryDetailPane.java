package view.panels;

import controller.CancelSaveCategoryHandler;
import controller.SaveCategoryHandler;
import controller.SelfTestController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CategoryDetailPane extends GridPane {
	private Button btnOK, btnCancel;
	private TextField titleField, descriptionField;
	private ComboBox categoryField;
	private SelfTestController selfTestController;
	Stage primaryStage = new Stage();

	public CategoryDetailPane(SelfTestController selfTestController) {
		this.selfTestController = selfTestController;
		this.setPrefHeight(150);
		this.setPrefWidth(300);
		
		this.setPadding(new Insets(5, 5, 5, 5));
		this.setVgap(5);
		this.setHgap(5);

		this.add(new Label("Title:"), 0, 0, 1, 1);
		titleField = new TextField();
		this.add(titleField, 1, 0, 1, 1);

		this.add(new Label("Description:"), 0, 1, 1, 1);
		descriptionField = new TextField();
		this.add(descriptionField, 1, 1, 1, 1);

		this.add(new Label("Main Category:"), 0, 2, 1, 1);
		categoryField = new ComboBox<>();
		this.add(categoryField, 1, 2, 1, 1);
		categoryField.setItems(selfTestController.getAllCategories());

		btnCancel = new Button("Cancel");
		btnCancel.setOnAction(event -> this.close());
		
		this.add(btnCancel, 0, 3, 1, 1);

		btnOK = new Button("Save");
		btnOK.isDefaultButton();
		btnOK.setOnAction(event -> this.sendInformationToController());
		this.add(btnOK, 1, 3, 1, 1);

		Scene scene = new Scene(this,240,240);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void sendInformationToController() {
		this.selfTestController.addCategoryToDatabase(this.titleField.getText(),this.categoryField.getValue().toString());
		this.close();
	}



	public void close(){
		primaryStage.close();
	}
}
