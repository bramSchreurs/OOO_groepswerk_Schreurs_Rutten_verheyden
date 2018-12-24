package model.databank;

import model.Categorie;
import model.Test;
import model.Vraag;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DatabaseWithtxt implements Databanken{
    private static String catLine, questLine;
    private static List<String> listCatName = new ArrayList<>();
    private static List<String> listCatDesc = new ArrayList<>();
    private static List<String> listQuestQuest = new ArrayList<>();
    private static List<String> listQuestAns = new ArrayList<>();
    private static List<String> listQuestPosAns = new ArrayList<>();
    public DatabaseWithtxt() {


        //gebruik Singleton
    }
    File quest = new File("TextFiles\\Questions.txt");
    Scanner scanQuest = null;
    File cat = new File("TextFiles\\Categories.txt");
    Scanner scanCat = null;
    Writer wr;

    public static void main(String[] args){

    }

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
    public void Addvraag(String vraag, ArrayList<String> mogAntwoorden, ArrayList<String> jusAntwoorden) {
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
            wr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletetest() {

    }

    @Override
    public void deleteCategorie() {
        
    }

    @Override
    public void deleteVraag() {

    }

    @Override
    public void Scanallevragen() {
        try {
            scanQuest = new Scanner(quest);
            while (scanQuest.hasNext()){
                questLine = scanQuest.nextLine();
                String[] parts = questLine.split("::", 3);
                listQuestQuest.add(parts[0]);
                listQuestPosAns.add(parts[1]);
                listQuestAns.add(parts[2]);
            }

            System.out.println("\nAll questions:\n");
            for (String n : listQuestQuest){
                System.out.println(n);
            }
            System.out.println("\nAll answers:\n");
            for (String d : listQuestAns){
                System.out.println(d);
            }
            System.out.println("\nAll possible answers:\n");
            for (String d : listQuestPosAns){
                System.out.println(d);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        scanQuest.close();
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


    @Override
    public void ScanalleTesten() {

    }

}
