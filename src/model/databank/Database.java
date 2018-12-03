package model.databank;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Database implements Databanken{
    private static String catLine, questLine;
    private static List<String> listCatName = new ArrayList<>();
    private static List<String> listCatDesc = new ArrayList<>();
    private static List<String> listQuestQuest = new ArrayList<>();
    private static List<String> listQuestAns = new ArrayList<>();
    private static List<String> listQuestPosAns = new ArrayList<>();
    public Database() {


        //gebruik Singleton
    }
    public static void main(String[] args){
        File cat = new File("TextFiles\\Categories.txt");
        Scanner scanCat = null;
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

        File quest = new File("TextFiles\\Questions.txt");
        Scanner scanQuest = null;
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

}
