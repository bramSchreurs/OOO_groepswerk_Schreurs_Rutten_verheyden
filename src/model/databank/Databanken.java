package model.databank;
//interface voor met databanken te werken

import model.Categorie;
import model.Test;
import model.Vraag;

import java.util.ArrayList;

public interface Databanken {
    //nieuwe testin databank steken
    void Addnewtest();
    // nieuwe Categorie in databank steken
    void AddnewCategorie(String naam, String beschrijving);
    //Nieuwe vraag in databank steken
    void Addvraag(String vraag, ArrayList<String> mogAntwoorden, ArrayList<String> jusAntwoorden, String feedback, String categorie, int score);
    // test uit databank halen
    void deletetest();
    //Categorie uit db halen
    void deleteCategorie(int index);
    //Vraag uit db halen
    void deleteVraag(int index);
    // Allen vragen in scannen
    void Scanallevragen();
    //Allen Categorien in scannen
    void ScanalleCatogorien();
    //Allen testen in scannen
    void ScanalleTesten();
    //Nieuwe test maken

}
