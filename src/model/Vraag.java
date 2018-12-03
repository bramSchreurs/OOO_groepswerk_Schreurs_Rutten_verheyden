package model;

import java.util.ArrayList;

public class Vraag {
    static int vragenIdStatic = 0;
    int vragenId;
    String vraagString;
    ArrayList correcteAntwoorden;
    ArrayList mogelijkeAntwoorden;
    String Feedback;
    Enum TypeVraag;
    int score;

    public Vraag(String vraagString, ArrayList correcteAntwoorden, ArrayList mogelijkeAntwoorden, String feedback, int score) {
        vragenIdStatic += 1;
        setVragenId();
        setCorrecteAntwoorden();
        setGegevenAntwoorden();
        setFeedback(feedback);
        setScore(score);
        addVraagToDatabase();
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

    public ArrayList getCorrecteAntwoorden() {
        return correcteAntwoorden;
    }

    public void setCorrecteAntwoorden() {
        this.correcteAntwoorden = new ArrayList<String>();
    }

    public ArrayList getMogelijkeAntwoorden() {
        return mogelijkeAntwoorden;
    }

    public void setGegevenAntwoorden() {
        this.mogelijkeAntwoorden = new ArrayList<String>();
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

    public void addVraagToDatabase(){
        //lorem ipsum

    }


}
