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
    void AddnewCategorie();
    //Nieuwe vraag in databank steken
    void Addvraag();
    // test uit databank halen
    void deletetest();
    //Categorie uit db halen
    void deleteCategorie();
    //Vraag uit db halen
    void deleteVraag();
    // Allen vragen in scannen
    ArrayList<Vraag>Scanallevragen();
    //Allen Categorien in scannen
    ArrayList<Categorie>ScanalleCatogorien();
    //Allen testen in scannen
    ArrayList<Test>ScanalleTesten();
    //Nieuwe test maken
    void MaaknieuweTest();
    //Nieuwe categorie maken
    void MaaknieuweCategorie();
    //Nieuwe vraag maken
    void MaaknieuweVraag();

}
