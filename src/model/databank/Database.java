package model.databank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Database {
    private static String name, description, question, answer;
    private static List<String> listCatName = new ArrayList<>();
    private static List<String> listCatDesc = new ArrayList<>();
    public Database() {


        //gebruik Singleton
    }
    public static void main(String[] args){
        Scanner scanCat = new Scanner("\\TextFiles\\Categories.txt");
        scanCat.useDelimiter("::");
        System.out.println(scanCat.nextLine());
        /*while(scanCat.hasNextLine()) {
            name = scanCat.next();
            scanCat.delimiter();
            description = scanCat.next();
            listCatName.add(name);
            listCatDesc.add(description);
        }
        System.out.println("All names:");
        for (String n : listCatName){
            System.out.println("\n" + n);
        }
        System.out.println("All descriptions:");
        for (String d : listCatDesc){
            System.out.println("\n" + d);
        }*/



    }



}
