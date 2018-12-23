package view.panels;

import controller.CategoryDetailHandler;
import controller.SelfTestController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import model.databank.DatabaseWithtxt;


public class CategoryOverviewPane extends GridPane {
	private TableView table;
	private Button btnNew;
	private String name, description;
	private SelfTestController controller = new SelfTestController(new DatabaseWithtxt());
	EventHandler<ActionEvent> newAction =  new CategoryDetailHandler();
	public CategoryOverviewPane(SelfTestController controller) {
		this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

		this.add(new Label("Categories:"), 0, 0, 1, 1);
		
		table = new TableView<>();
		table.setPrefWidth(REMAINING);
        TableColumn nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory("naam"));
        table.getColumns().add(nameCol);
        TableColumn descriptionCol = new TableColumn<>("Description");
        descriptionCol.setCellValueFactory(new PropertyValueFactory("beschrijving"));
        table.getColumns().add(descriptionCol);

		this.add(table, 0, 1, 2, 6);
		table.setItems(getController().getCategorieTableItems());
		
		btnNew = new Button("New");
		this.add(btnNew, 0, 11, 1, 1);
		this.btnNew.setOnAction(event -> this.createCategoryDetailPlane());
	}

	private void createCategoryDetailPlane() {
		new CategoryDetailPane(this.controller);
	}


	public SelfTestController getController() {
		return controller;
	}

	public void setController(SelfTestController controller) {
		this.controller = controller;
	}


	public void setNewAction(EventHandler<ActionEvent> newAction) {

		btnNew.setOnAction(newAction);
	}

	public void setEditAction(EventHandler<MouseEvent> editAction) {
		table.setOnMouseClicked(editAction);
	}

}
