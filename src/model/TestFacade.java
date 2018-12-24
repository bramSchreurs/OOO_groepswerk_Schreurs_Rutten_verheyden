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
    public void TestaddCategorie( Test test,Categorie categorie){
        test.addCategorie(categorie);

    }
    public void TestaddVraag(Test test,Vraag vraag){
        test.addVraag(vraag);
    }

    public String TestgetNaam(Test test) {
        return test.getNaam() ;
    }

    public void TestsetNaam(String naam,Test test) {
        test.setNaam(naam);
    }

    public ArrayList<Categorie> TestgetCategorieën(Test test)
    {
        return test.getCategorieën();
    }

    public void TestsetCategorieën(ArrayList categorieën,Test test)
    {
        test.setCategorieën(categorieën);
    }

    public ArrayList<Vraag> TestgetVragen(Test test) {
        return test.getVragen();
    }

    public void setVragen(ArrayList vragen,Test test) {
        test.setVragen(vragen);
    }
    public void setFeedbackWijze(Enum FeedbackWijze,Test test){
       test.setFeedbackWijze(FeedbackWijze);
    }


    public void TestaddObserver(Observer observer,Test test) {
            test.addObserver(observer);
    }


    public void TestremoveObserver(Observer observer,Test test) {
        test.removeObserver(observer);
    }


    public void TestnotifyObservers(Test test) {
        test.notifyObservers();

    }
    //Observer methods
    public void Observerupdate(Observer observer){
        observer.update();
    }
    //Subject methods
    public void SubjectaddObserver(Subject subject,Observer observer){
        subject.addObserver(observer);
    }

    public void SubjectremoveObserver(Subject subject,Observer observer){
        subject.removeObserver(observer);
    }


    public void SubjectnotifyObservers(Subject subject){
        subject.notifyObservers();
    }

    //Categorie
        //Catogorie aanmaken
    public Categorie createCategorie(String naam,String beschrijving)
        {
        return new Categorie(naam,beschrijving);
    }

}
