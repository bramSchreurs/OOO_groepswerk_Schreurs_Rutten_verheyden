package model;

import model.databank.Databanken;
import model.databank.DatabaseWithtxt;

import java.util.ArrayList;

public class Categorie {
    String naam;
    ArrayList<Vraag> vragenLijst;
    String beschrijving;
    DatabaseWithtxt db = new DatabaseWithtxt();

    public Categorie(String naam,String beschrijving){
        setNaam(naam);
        setVragenLijst(vragenLijst);
        setBeschrijving(beschrijving);
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }


    public ArrayList getVragenLijst() {
        return vragenLijst;
    }

    public void setVragenLijst(ArrayList vragenLijst) {
        this.vragenLijst = new ArrayList<Vraag>();
        //haal vragen uit database


    }

    @Override
    public String toString(){
        return this.naam;
    }
}
