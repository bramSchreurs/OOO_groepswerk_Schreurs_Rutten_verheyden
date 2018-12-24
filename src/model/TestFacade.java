package model;

import java.util.ArrayList;

public class TestFacade {
    // Vragen methodes
     //Maak nieuwe vraag aan
    public  Vraag Createvraag(String vraagString, ArrayList correcteAntwoorden, ArrayList mogelijkeAntwoorden, String feedback,Categorie categorie, int score){
        return new Vraag(vraagString,correcteAntwoorden, mogelijkeAntwoorden,feedback,categorie,score);
    }
    public Categorie VraaggetCategorie(Vraag vraag) {
        return vraag.categorie;
    }

    public void VraagsetCategorie(Vraag vraag,Categorie categorie)
    {
       vraag.setCategorie(categorie);
    }

    public int VraagsgetVragenId(Vraag vraag)
    {
        return vraag.getVragenId();
    }

    public void VraagssetVragenId(Vraag vraag)
    {
        vraag.setVragenId();
    }

    public String VraagsgetVraagString(Vraag vraag)
    {
        return vraag.getVraagString();
    }

    public void VraagssetVraagString(Vraag vraag,String vraags)
    {
        vraag.setVraagString(vraags);
    }

    public ArrayList VraagsgetCorrecteAntwoorden(Vraag vraag)
    {
        return vraag.getCorrecteAntwoorden();
    }

    public void VraagssetCorrecteAntwoorden(Vraag vraag,ArrayList<String> strings)
    {
        vraag.setCorrecteAntwoorden(strings);
    }

    public ArrayList VraagsgetMogelijkeAntwoorden(Vraag vraag)
    {
        return vraag.getMogelijkeAntwoorden();
    }

    public void VraagssetGegevenAntwoorden(Vraag vraag,ArrayList<String> strings)
    {
        vraag.setGegevenAntwoorden(strings);
    }

    public String VraagsgetFeedback(Vraag vraag)
    {
        return vraag.getFeedback();
    }

    public void VraagssetFeedback(Vraag vraag,String feedback)
    {
        vraag.setFeedback(feedback);
    }

    public int VraagsgetScore(Vraag vraag)
    {
        return vraag.getScore();
    }

    public void VraagssetScore(Vraag vraag,int score)
    {
        vraag.setScore(score);
    }

    public void VraagsaddVraagToDatabase(Vraag vraag)
    {
        vraag.addVraagToDatabase();

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
