package model;

import java.util.ArrayList;

public class Vraag {
    static int vragenId = 0;
    String vraagString;
    ArrayList correcteAntwoorden;
    ArrayList gegevenAntwoorden;
    String Feedback;
    int score;

    public Vraag(String vraagString, ArrayList correcteAntwoorden, ArrayList gegevenAntwoorden, String feedback, int score) {
        vragenId += 1;
        setVragenId(getVragenId());
        setCorrecteAntwoorden();
        setGegevenAntwoorden();
        setFeedback(feedback);
        setScore(score);
        addVraagToDatabase();
    }

    public int getVragenId() {
        return vragenId;
    }

    public void setVragenId(int vragenId) {
        this.vragenId = vragenId;
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

    public ArrayList getGegevenAntwoorden() {
        return gegevenAntwoorden;
    }

    public void setGegevenAntwoorden() {
        this.gegevenAntwoorden = new ArrayList<String>();
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

    }


}
