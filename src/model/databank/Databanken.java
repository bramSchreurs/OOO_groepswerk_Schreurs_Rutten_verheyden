package model.databank;

import model.Categorie;
import model.Test;
import model.Vraag;

import java.util.ArrayList;

public interface Databanken {
    void Addnewtest();
    void AddnewCategorie();
    void Addvraag();
    void deletetest();
    void deleteCategorie();
    void deleteVraag();
    ArrayList<Vraag>Scanallevragen();
    ArrayList<Categorie>ScanalleCatogorien();
    ArrayList<Test>ScanalleTesten();
    void MaaknieuweTest();
    void MaaknieuweCategorie();
    void MaaknieuweVraag();

}
