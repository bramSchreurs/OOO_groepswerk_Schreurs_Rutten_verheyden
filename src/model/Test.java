package model;

import java.util.ArrayList;

import static model.FeedbackWijze.*;

public class Test {
    String naam;
    ArrayList categorieën;
    ArrayList vragen;
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

    public ArrayList getCategorieën() {
        return categorieën;
    }

    public void setCategorieën(ArrayList categorieën) {
        this.categorieën = categorieën;
    }

    public ArrayList getVragen() {
        return vragen;
    }

    public void setVragen(ArrayList vragen) {
        this.vragen = vragen;
    }
    public void setFeedbackWijze(Enum FeedbackWijze){
        this.feedbackWijze = FeedbackWijze;
    }
}
