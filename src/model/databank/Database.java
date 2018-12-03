package model.databank;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Database {
    private static String name, description, question, answer;
    private static List<String> listCatName = new ArrayList<>();
    private static List<String> listCatDesc = new ArrayList<>();
    public Database() {

    }
    public static void main(String[] args){
        File cat = new File("TextFiles\\Categories.txt");
        Scanner scanCat = null;
        try {
            scanCat = new Scanner(cat);
            scanCat.useDelimiter("::");
            while(scanCat.hasNextLine()) {
                listCatName.add(scanCat.next());
                listCatDesc.add(scanCat.next());
                scanCat.nextLine();
            }
            System.out.println("All names:");
            for (String n : listCatName){
                System.out.println("\n" + n);
            }
            System.out.println("All descriptions:");
            for (String d : listCatDesc){
                System.out.println("\n" + d);
            }

            /*scanCat = new Scanner(cat);
            scanCat.useDelimiter("::");
            System.out.println(scanCat.next());
            scanCat.delimiter();
            System.out.println(scanCat.next());*/
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        scanCat.close();

    }



}
