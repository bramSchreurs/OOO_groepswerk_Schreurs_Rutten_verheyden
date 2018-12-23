package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.databank.DatabaseWithtxt;
import view.panels.CategoryDetailPane;




public class CancelSaveCategoryHandler implements EventHandler<ActionEvent> {



    @Override
    public void handle(ActionEvent event) {
        CategoryDetailPane pane = (CategoryDetailPane) event.getSource();
        pane.close();



        //CategoryDetailPane;
    }
}
