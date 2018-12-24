package view.panels;

import controller.SelfTestController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Observer;
import model.databank.DatabaseWithtxt;

public class MessagePane extends GridPane implements Observer {
	private Button testButton;
	private SelfTestController selfTestController;
	private Label categorieEnUitslag;
	private Stage oldStage;
	public MessagePane (Stage oldStage, SelfTestController selfTestController){
		this.oldStage = oldStage;
		this.selfTestController = selfTestController;
		categorieEnUitslag = new Label();
		categorieEnUitslag.setText(selfTestController.getResults());
		add(categorieEnUitslag,0,0,1,1);
	    setBorder(new Border(new BorderStroke(Color.BLACK, 
	            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

		this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);
        
		testButton = new Button("Evaluate");
		testButton.setOnAction(event -> this.createTestPane());
		add(testButton, 0,1,1,1);
		setHalignment(testButton, HPos.CENTER);
	}

	private void createTestPane() {
		new TestPane(selfTestController);

	}

	@Override
	public void update() {
			oldStage.close();
	}
}
