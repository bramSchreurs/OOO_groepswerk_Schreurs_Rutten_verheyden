package model;

import model.databank.DatabaseWithtxt;

import java.util.ArrayList;
import java.util.List;

public class Vraag {
    static int vragenIdStatic = 0;
    int vragenId;
    String vraagString;
    List correcteAntwoorden;
    List mogelijkeAntwoorden;
    String Feedback;
    Categorie categorie;
    Enum TypeVraag;
    int score;
    DatabaseWithtxt db = new DatabaseWithtxt();

    public Vraag(String vraagString, ArrayList correcteAntwoorden, ArrayList mogelijkeAntwoorden, String feedback,Categorie categorie, int score) {
        vragenIdStatic += 1;
        setVragenId();
        setCorrecteAntwoorden(correcteAntwoorden);
        setGegevenAntwoorden(mogelijkeAntwoorden);
        setFeedback(feedback);
        setScore(score);
        setVraagString(vraagString);
        setCategorie(categorie);

    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public int getVragenId() {
        return vragenId;
    }

    public void setVragenId() {
        this.vragenId = vragenIdStatic;
            }

    public String getVraagString() {
        return vraagString;
    }

    public void setVraagString(String vraagString) {
        this.vraagString = vraagString;
    }

    public List getCorrecteAntwoorden() {
        return correcteAntwoorden;
    }

    public void setCorrecteAntwoorden(List<String> strings) {
        this.correcteAntwoorden = strings;
    }

    public List getMogelijkeAntwoorden() {
        return mogelijkeAntwoorden;
    }

    public void setGegevenAntwoorden(List<String> strings) {
        this.mogelijkeAntwoorden = strings;
    }

    public String getFeedback() {
        return Feedback;
    }

    public void setFeedback(String feedback) {
        Feedback = feedback;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }





}
