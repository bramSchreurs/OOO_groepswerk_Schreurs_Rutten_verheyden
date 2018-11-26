package model;

import java.util.ArrayList;

public class Categorie {
    String naam;
    String vak;
    ArrayList vragenLijst;

    public Categorie(String naam,String vak){
        setNaam(naam);
        setVak(vak);
        setVragenLijst(vragenLijst);
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
        this.vragenLijst = vragenLijst;
        //
    }
}
