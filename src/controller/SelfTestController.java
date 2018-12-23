package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Categorie;
import model.Test;
import model.Vraag;
import model.databank.DatabaseWithtxt;
import view.panels.CategoryOverviewPane;
import view.panels.QuestionOverviewPane;

import java.util.ArrayList;

public class SelfTestController {
    DatabaseWithtxt database;
    Test test = new Test("voedseltest");
    CategoryOverviewPane categorieOverviewPane;
    QuestionOverviewPane questionOverviewPane;

    public SelfTestController(DatabaseWithtxt database){
        setDatabase(database);
        setTest(test);
    }

    public void setDatabase(DatabaseWithtxt database) {
        this.database = database;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public DatabaseWithtxt getDatabase() {
        return this.database;
    }

    public Test getTest() {
        return this.test;
    }

    public CategoryOverviewPane getCategorieOverviewPane() {
        return this.categorieOverviewPane;
    }

    public void setCategorieOverviewPane(CategoryOverviewPane categorieOverviewPane) {
        this.categorieOverviewPane = categorieOverviewPane;
    }

    public QuestionOverviewPane getQuestionOverviewPane() {
        return questionOverviewPane;
    }

    public void setQuestionOverviewPane(QuestionOverviewPane questionOverviewPane) {
        this.questionOverviewPane = questionOverviewPane;
    }

    public ObservableList<Vraag> getTableItems(){
        ObservableList list = FXCollections.observableArrayList();
        Categorie categorie = new Categorie("Voedsel","Voedsel","Ja zo van die dingen die je eet");
        ArrayList<String> kaas = new ArrayList<String>();
        ArrayList<String> worst = new ArrayList<String>();
        kaas.add("kaas");
        worst.add("worst");
        Vraag vraag = new Vraag("Wat is lekker?", kaas, worst,"fout",categorie,0);
         test.addVraag(vraag);
        for (Vraag vraag2:test.getVragen()) {
            list.add(vraag2);

        }

        
        return list;

    }

    public ObservableList<Vraag> getCategorieTableItems(){
        ObservableList list = FXCollections.observableArrayList();
        Categorie categorie = new Categorie("Voedsel","Voedsel","Ja zo van die dingen die je eet");
        ArrayList<String> kaas = new ArrayList<String>();
        ArrayList<String> worst = new ArrayList<String>();
        kaas.add("kaas");
        worst.add("worst");
        Vraag vraag = new Vraag("Wat is lekker?", kaas, worst,"fout",categorie,0);
        test.addVraag(vraag);
        test.addCategorie(categorie);
        for (Categorie categorie1:test.getCategorieën()) {
            list.add(categorie1);

        }


        return list;

    }
}
