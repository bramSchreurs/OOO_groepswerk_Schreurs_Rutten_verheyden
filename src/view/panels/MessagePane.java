package view.panels;

import java.util.Observer;

import controller.SelfTestController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import model.databank.DatabaseWithtxt;

public class MessagePane extends GridPane {
	private Button testButton;
	
	public MessagePane (){
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
		new TestPane(new SelfTestController(new DatabaseWithtxt()));
	}

}
