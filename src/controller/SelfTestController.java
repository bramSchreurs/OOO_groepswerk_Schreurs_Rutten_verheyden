package controller;

import model.Test;
import model.databank.Database;
import view.panels.CategoryOverviewPane;
import view.panels.QuestionOverviewPane;

public class SelfTestController {
    Database database;
    Test test;
    CategoryOverviewPane categorieOverviewPane;
    QuestionOverviewPane questionOverviewPane;

    public SelfTestController(Database database){
        setDatabase(database);
        setTest(test);
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    public void setTest(Test test) {
        this.test = test;
    }
}
