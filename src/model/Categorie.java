package model;

import java.util.ArrayList;

public class Categorie {
    String naam;
    String vak;
    ArrayList<Vraag> vragenLijst;
    String beschrijving;

    public Categorie(String naam,String vak,String beschrijving){
        setNaam(naam);
        setVak(vak);
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

    public String getVak() {
        return vak;
    }

    public void setVak(String vak) {
        this.vak = vak;
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
        return this.vak;
    }
}
