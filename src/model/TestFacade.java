package model;

import java.util.ArrayList;

public class TestFacade {
    // Vragen methodes
     //Maak nieuwe vraag aan
    public  Vraag Createvraag(String vraagString, ArrayList correcteAntwoorden, ArrayList mogelijkeAntwoorden, String feedback,Categorie categorie, int score){
        return new Vraag(vraagString,correcteAntwoorden, mogelijkeAntwoorden,feedback,categorie,score);
    }

    //Test methodes
        //Testen maken
   public Test createTest(String naam){
        return new Test(naam);
   }
    //Categorie
        //Catogorie aanmaken
    public Categorie createCategorie(String naam,String beschrijving)
        {
        return new Categorie(naam,beschrijving);
    }

}
