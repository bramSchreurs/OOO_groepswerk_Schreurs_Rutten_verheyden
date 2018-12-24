package controller;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;
import model.databank.DatabaseWithtxt;
import view.panels.CategoryOverviewPane;
import view.panels.QuestionOverviewPane;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelfTestController implements Subject {
    DatabaseWithtxt database;
    Test test = new Test("voedseltest");
    CategoryOverviewPane categorieOverviewPane;
    QuestionOverviewPane questionOverviewPane;
    TestFacade  testFacade= new TestFacade();
    ArrayList<String> correcteAntwoorden;
    ArrayList<String> mogelijkeAntwoorden;
    ArrayList<String> alleAntwoorden;
    private int counter = 0;
    ArrayList<Observer> observers;

    public SelfTestController(DatabaseWithtxt database){
        observers = new ArrayList<Observer>();
        setDatabase(database);
        setTest(test);
        test.setFeedbackWijze(FeedbackWijze.FEEDBACK);
        correcteAntwoorden = new ArrayList<String>();
        correcteAntwoorden.add("zuivelProduct");
        mogelijkeAntwoorden = new ArrayList<String>();
        mogelijkeAntwoorden.add("Vleesproduct");
        Categorie voedsel = new Categorie("Voedsel","Eetbare dingen");
        Vraag vraag = new Vraag("Kaas?",correcteAntwoorden,mogelijkeAntwoorden,"Ja zuivelproduct he",voedsel,0);
        test.addVraag(vraag);
        ArrayList<String> correcteAntwoorden2 = new ArrayList<String>();
        ArrayList<String> mogelijkeAntwoorden2 = new ArrayList<String>();
        correcteAntwoorden2.add("Vleesproduct");
        mogelijkeAntwoorden2.add("Zuivelproduct");
        Vraag vraag2 = new Vraag("Worst?",correcteAntwoorden2,mogelijkeAntwoorden2,"Ja vleesproduct he",voedsel,0);
        test.addCategorie(voedsel);

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

        for (Vraag vraag2:test.getVragen()) {
            list.add(vraag2);

        }


        return list;

    }

    public ObservableList<Vraag> getCategorieTableItems(){
        ObservableList list = FXCollections.observableArrayList();

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
        if (counter>=getTest().getVragen().size()||getTest().getVragen().get(counter).getVraagString()==null || getTest().getVragen().get(counter).getVraagString().isEmpty()){
            return null;
        }
        else {
            String vraag = getTest().getVragen().get(counter).getVraagString();
            return vraag;
        }
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

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void submitAnswer(List<String> antwoorden) {
        System.out.println(counter + "hier zo");
        if (counter >= test.getVragen().size()) {
            notifyObservers();
            return;
        }
        test.getVragen().get(counter).setScore(1);
        for (String antwoord:antwoorden) {
            System.out.println(antwoord);
            System.out.println(counter);
            if (!test.getVragen().get(counter).getCorrecteAntwoorden().contains(antwoord)){
                test.getVragen().get(counter).setScore(0);
            }

        }


    }

    public String getResults() {
        boolean allTrue = true;
        for (Vraag vraag3: test.getVragen()) {
            if (vraag3.getScore()==0){
                allTrue = false;
            }
        }
        if (allTrue == true){
            return "Wauw je hebt alles juist, mooi zo!";
        }
        if (test.getFeedbackWijze().equals("Score")) {
            String result = "";

            int correctCounter = 0;
            int alleCounter = 0;
            for (Vraag vraag : testFacade.TestgetVragen(test)) {
                correctCounter += vraag.getScore();
                alleCounter += 1;

            }
            result += "Your score: " + correctCounter + "/" + alleCounter + "\n";

            for (Categorie categorie : testFacade.TestgetCategorieën(test)) {
                int correctPerCategorie = 0;
                int aantalPerCategorie = 0;
                for (Vraag vraag2 : testFacade.TestgetVragen(test)) {
                    if (vraag2.getCategorie().equals(categorie)) {
                        correctPerCategorie += vraag2.getScore();
                        aantalPerCategorie += 1;
                    }


                }
                result += categorie.getNaam() + ": " + correctPerCategorie + "/" + aantalPerCategorie + "\n";


            }
            return result;
        }
        if (test.getFeedbackWijze().equals("Feedback")) {
            String result2 = "";
            for (Vraag vraag : test.getVragen()) {
                if (vraag.getScore() == 0) {
                    result2 += vraag.getFeedback() + "\n";
                }
            }
            return result2;
        }
        return null;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);

    }

    @Override
    public void notifyObservers() {
        for (Observer observer: observers) {
            observer.update();
        }
    }
}
