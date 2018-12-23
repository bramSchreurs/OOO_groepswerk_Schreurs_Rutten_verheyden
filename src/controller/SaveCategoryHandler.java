package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.databank.DatabaseWithtxt;
import view.panels.CategoryDetailPane;




    public class SaveCategoryHandler implements EventHandler<ActionEvent> {
        CategoryDetailPane detailPane;
        SelfTestController controller = new SelfTestController(new DatabaseWithtxt());


        @Override
        public void handle(ActionEvent event) {

            controller.addCategoryToDatabase("naam","categorie");
            CategoryDetailPane pane = (CategoryDetailPane) event.getSource();
            pane.close();


            //CategoryDetailPane;
        }
    }

