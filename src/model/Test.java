package model;

import java.util.ArrayList;

import static model.FeedbackWijze.*;

public class Test implements Subject{
    String naam;
    ArrayList<Categorie> categorieën;
    ArrayList<Vraag> vragen;
    Enum feedbackWijze;

    public Test(String naam){
        setNaam(naam);
        categorieën = new ArrayList<Categorie>();
        vragen = new ArrayList<Vraag>();

    }
    public void addCategorie(Categorie categorie){
        this.categorieën.add(categorie);

    }
    public void addVraag(Vraag vraag){
        this.vragen.add(vraag);
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public ArrayList<Categorie> getCategorieën() {
        return categorieën;
    }

    public void setCategorieën(ArrayList categorieën) {
        this.categorieën = categorieën;
    }

    public ArrayList<Vraag> getVragen() {
        return vragen;
    }

    public void setVragen(ArrayList vragen) {
        this.vragen = vragen;
    }
    public void setFeedbackWijze(Enum FeedbackWijze){
        this.feedbackWijze = FeedbackWijze;
    }
    public String getFeedbackWijze(){
        return this.feedbackWijze.toString();
    }

    @Override
    public void addObserver(Observer observer) {

    }

    @Override
    public void removeObserver(Observer observer) {

    }

    @Override
    public void notifyObservers() {

    }
}
