package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Categorie;
import model.Test;
import model.TestFacade;
import model.Vraag;
import model.databank.DatabaseWithtxt;
import view.panels.CategoryOverviewPane;
import view.panels.QuestionOverviewPane;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelfTestController {
    DatabaseWithtxt database;
    Test test = new Test("voedseltest");
    CategoryOverviewPane categorieOverviewPane;
    QuestionOverviewPane questionOverviewPane;
    TestFacade  testFacade= new TestFacade();
    ArrayList<String> correcteAntwoorden;
    ArrayList<String> mogelijkeAntwoorden;
    ArrayList<String> alleAntwoorden;
    private int counter = 0;

    public SelfTestController(DatabaseWithtxt database){
        setDatabase(database);
        setTest(test);
        correcteAntwoorden = new ArrayList<String>();
        correcteAntwoorden.add("zuivelProduct");
        mogelijkeAntwoorden = new ArrayList<String>();
        mogelijkeAntwoorden.add("Vleesproduct");
        Vraag vraag = new Vraag("Kaas?",correcteAntwoorden,mogelijkeAntwoorden,"Ja zuivelproduct he",new Categorie("Voedsel","Eetbare dingen"),0);
        Vraag vraag2 = new Vraag("Worst?",correcteAntwoorden,mogelijkeAntwoorden,"Ja vleesproduct he",new Categorie("Voedsel","Eetbare dingen"),0);

        test.addVraag(vraag);
        test.addVraag(vraag2);
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
        Categorie categorie = new Categorie("Voedsel","Ja zo van die dingen die je eet");
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
        Categorie categorie = new Categorie("Voedsel","Ja zo van die dingen die je eet");
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

    public void addCategoryToDatabase(String naam, String categorie){
        getDatabase().AddnewCategorie(naam,categorie);


    }

    public ObservableList<Categorie> getAllCategories(){
        ObservableList list = FXCollections.observableArrayList();
        Categorie categorie = new Categorie("Voedsel","Ja zo van die dingen die je eet");
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

    public void addQuestionToDatabase(String vraagString,String feedBack, Categorie categorie){

        testFacade.Createvraag(vraagString, correcteAntwoorden,mogelijkeAntwoorden,feedBack,categorie,0);
        this.correcteAntwoorden.clear();
        this.mogelijkeAntwoorden.clear();
        //getDatabase().Addvraag(vraagString,this.correcteAntwoorden,this.mogelijkeAntwoorden,feedBack,categorie,0);
    }

    public void addCorrectAntwoord(String antwoord){
        this.correcteAntwoorden.add(antwoord);

    }

    public void addMogelijkAntwoord(String antwoord){
        this.mogelijkeAntwoorden.add(antwoord);

    }

    public void raiseCounter(){
        this.counter += 1;
    }
    public void lowerCounter(){
        this.counter -=1;
    }

    public String getNextQuestionString() {
        if (counter>=getTest().getVragen().size()){
            return null;
        }
        if (getTest().getVragen().get(counter).getVraagString()==null || getTest().getVragen().get(counter).getVraagString().isEmpty()){
            return null;
        }
        System.out.println(getTest().getVragen().get(counter).getVraagString());
        String vraag =  getTest().getVragen().get(counter).getVraagString();
        raiseCounter();
        return vraag;
    }

    public ArrayList<String> getAlleAntwoorden() {
        alleAntwoorden =new ArrayList<String>();
        for (String antwoord:correcteAntwoorden) {
            alleAntwoorden.add(antwoord);

        }
        for (String antwoord1: mogelijkeAntwoorden) {
            alleAntwoorden.add(antwoord1);

        }
        Collections.shuffle(alleAntwoorden);
        return alleAntwoorden;
    }

    public void submitAnswer(List<String> antwoorden) {
        if (counter >= test.getVragen().size())
        {
            return;
        }
        test.getVragen().get(counter).setScore(1);
        for (String antwoord:antwoorden) {
            if (!test.getVragen().get(counter).getCorrecteAntwoorden().contains(antwoord)){
                test.getVragen().get(counter).setScore(0);
            }

        }


    }

    public String getResults() {
        String result = "";
        int correctCounter = 0;
        int alleCounter = 0;
        for (Vraag vraag : testFacade.TestgetVragen(test)) {
            correctCounter += vraag.getScore();
            alleCounter += 1;

        }
        for (Categorie categorie : testFacade.TestgetCategorieën(test)) {
            result += categorie.getNaam();

        }
        test.getCategorieën();
        result += "Your score: " + correctCounter + "/" + alleCounter + "/n";
        return result;
    }
}
