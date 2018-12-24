package model.databank;

import model.Categorie;
import model.Vraag;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DatabaseWithtxt implements Databanken{
    private String catLine, questLine;
    private List<String> listCatName = new ArrayList<>();
    private List<String> listCatDesc = new ArrayList<>();
    private List<String> listQuestQuest = new ArrayList<>();
    private ArrayList<List<String>> listQuestAns = new ArrayList<>();
    private ArrayList<List<String>> listQuestPosAns = new ArrayList<>();
    private List<String> listQuestCat = new ArrayList<>();
    private List<String> listQuestFeedback = new ArrayList<>();
    private List<String> listQuestScore = new ArrayList<>();
    private List<Vraag> vragenlijst = new ArrayList<>();
    private List<Categorie> categorielijst = new ArrayList<>();
    private ArrayList<String> mogAns = new ArrayList<>();
    private ArrayList<String> justAns = new ArrayList<>();
    private Categorie categorie;
    private Vraag vraag;
    public DatabaseWithtxt() {


        //gebruik Singleton
    }
    File quest = new File("TextFiles\\Questions.txt");
    Scanner scanQuest = null;
    File cat = new File("TextFiles\\Categories.txt");
    Scanner scanCat;
    Writer wr;

    @Override
    public void Addnewtest() {

    }

    @Override
    public void AddnewCategorie(String naam, String beschrijving) {
        try {
            wr = new FileWriter("TextFiles\\Categories.txt");
            wr.append("\n" + naam);
            wr.flush();
            wr.append("::");
            wr.flush();
            wr.append(beschrijving);
            wr.close();
        } catch (IOException e1) {
                e1.printStackTrace();
        }
    }

    @Override
    public void Addvraag(String vraag, ArrayList<String> mogAntwoorden, ArrayList<String> jusAntwoorden, String feedback, String categorie, int score) {
        try {
            wr = new FileWriter("TextFiles\\Questions.txt");
            wr.append("\n" + vraag);
            wr.flush();
            wr.append("::");
            wr.flush();
            for (int i = 0; i<mogAntwoorden.size(); i++){
                if (i != 0){
                    wr.append(", ");
                    wr.flush();
                    wr.append(mogAntwoorden.get(i));
                    wr.flush();
                }
                else{
                    wr.append(mogAntwoorden.get(i));
                    wr.flush();
                }
            }
            wr.append("::");
            for (int i = 0; i<jusAntwoorden.size(); i++){
                if (i != 0){
                    wr.append(", ");
                    wr.flush();
                    wr.append(jusAntwoorden.get(i));
                    wr.flush();
                }
                else{
                    wr.append(jusAntwoorden.get(i));
                    wr.flush();
                }
            }
            wr.append("::");
            wr.flush();
            wr.append(feedback);
            wr.append("::");
            wr.flush();
            wr.append(categorie);
            wr.append("::");
            wr.flush();
            wr.append(Integer.toString(0));
            wr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletetest() {

    }

    @Override
    public void deleteCategorie(int index) {
            /*String lineToRemove = "";
            String currentLine;
            lineToRemove += listCatName.get(index);
            lineToRemove += "::";
            lineToRemove += listCatDesc.get(index);

        listCatName.remove(index);
        listCatDesc.remove(index);
        */

    }

    @Override
    public void deleteVraag(int index) {

    }

    @Override
    public void Scanallevragen() {
        try {
            scanQuest = new Scanner(quest);
            while (scanQuest.hasNext()){
                questLine = scanQuest.nextLine();
                String[] parts = questLine.split("::", 5);
                listQuestQuest.add(parts[0]);
                String[] posAns = parts[1].split(", ");
                for (String s : posAns){
                    mogAns.add(s);
                }
                listQuestPosAns.add(mogAns);
                String[] ans = parts[2].split(", ");
                for (String s : ans){
                    justAns.add(s);
                }
                listQuestAns.add(justAns);
                listQuestFeedback.add(parts[3]);
                listQuestCat.add(parts[4]);
                listQuestScore.add(parts[5]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        scanQuest.close();
    }
    public List<Vraag> maakVragenLijst(){
        for (int i = 0; i<listQuestQuest.size(); i++){
            vraag.setVraagString(listQuestQuest.get(i));
            vraag.setCorrecteAntwoorden(listQuestPosAns.get(i));
            vraag.setGegevenAntwoorden(listQuestAns.get(i));
            vraag.setFeedback(listQuestFeedback.get(i));
            for (Categorie c : categorielijst){
                if (c.getNaam().equals(listQuestCat.get(i))){
                    vraag.setCategorie(c);
                }
            }
            vraag.setScore(0);
            vragenlijst.add(vraag);
        }
        return vragenlijst;
    }
    @Override
    public void ScanalleCatogorien()
    {
        try {
            scanCat = new Scanner(cat);
            while (scanCat.hasNext()){
                catLine = scanCat.nextLine();
                String[] parts = catLine.split("::", 2);
                listCatName.add(parts[0]);
                listCatDesc.add(parts[1]);
            }

            System.out.println("\nAll names:\n");
            for (String n : listCatName){
                System.out.println(n);
            }
            System.out.println("\nAll descriptions:\n");
            for (String d : listCatDesc){
                System.out.println(d);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        scanCat.close();
    }

    public List<Categorie> maakCategorieLijst(){
        for (int i = 0; i<listCatName.size(); i++){
            categorie.setNaam(listCatName.get(i));
            categorie.setNaam(listCatDesc.get(i));
            categorielijst.add(categorie);
        }
        return categorielijst;
    }

    @Override
    public void ScanalleTesten() {

    }

    public List<String> getListCatName(){
        return listCatName;
    }

    public List<String> getListCatDesc(){
        return listCatDesc;
    }

    public List<String> getListQuestQuest(){
        return listQuestQuest;
    }

    public List<List<String>> getListQuestAns(){
        return listQuestAns;
    }

    public List<String> getListQuestCat(){
        return listQuestCat;
    }

    public List<String> getListQuestFeedback(){
        return listQuestFeedback;
    }

    public List<String> getListQuestScore(){
        return listQuestScore;
    }

    public List<List<String>> getListQuestPosAns(){
        return listQuestPosAns;
    }


}
