package ReadFileWriteDatabase;



import ReadFileWriteDatabase.fruits.Apple;
import ReadFileWriteDatabase.fruits.Banana;
import ReadFileWriteDatabase.fruits.Fruits;
import ReadFileWriteDatabase.fruits.Orance;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<ArrayList<String>> fruits = new ArrayList<>();
        ArrayList<String> fruit = new ArrayList<>();

        try(Scanner input = new Scanner(new File("C:\\GIT\\jdbc-connection\\src\\ReadFileWriteDatabase\\data.csv"))){

            while (input.hasNextLine()){
                String[] data = input.nextLine().split(",");
                for (int i=0; i< data.length; i++){
                    fruit.add(data[i]);
                }
//                fruits.add(fruit);
                //fruit.addAll(Arrays.asList(data));

              /*  ArrayList<ArrayList<String>> outerList = new ArrayList<>();

                // Loop through each array in the array of arrays
                for (String[] innerArray : arrayOfArrays) {
                    // Create a new inner ArrayList and add elements from the current array
                    ArrayList<String> innerList = new ArrayList<>();
                    for (String item : innerArray) {
                        innerList.add(item);
                    }
                    // Add the inner ArrayList to the outer ArrayList
                    outerList.add(innerList);
                }*/

            }
            fruits.add(fruit);
               /* int id =Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                String buyer = data[2].trim();
                String seller = data[3].trim();
                double price = Double.parseDouble(data[4].trim());
                Date buyDate = new Date(new SimpleDateFormat("YYYY-MM-DD").parse(data[5]).getTime());
                Date sellDate = new Date(new SimpleDateFormat("YYYY-MM-DD").parse(data[5]).getTime());

                if (name.equalsIgnoreCase("apple")){
                    fruits.add(new Apple(id, name, buyer, seller, price, buyDate.toLocalDate(), sellDate.toLocalDate()));
                } else if (name.equalsIgnoreCase("orange")) {
                    fruits.add(new Orance(id, name, buyer, seller, price, buyDate.toLocalDate(), sellDate.toLocalDate()));
                } else if (name.equalsIgnoreCase("banana")) {
                    fruits.add(new Banana(id, name, buyer, seller, price, buyDate.toLocalDate(), sellDate.toLocalDate()));

                }*/

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        String[][] fruitsArray = new String[fruits.size()][1];
        for (int i = 0; i < fruits.size(); i++) {
            ArrayList<String> fruitList = fruits.get(i);
            fruitsArray[i] = new String[fruitList.size()];
            for (int j = 0; j < fruitList.size(); j++) {
                fruitsArray[i][j] = fruitList.get(j);
            }
        }

        InsertFruits insertFruits = new InsertFruits();
        insertFruits.insertDummyData(fruitsArray);


       /* ArrayList<Fruits> fruitsArrayList = new ArrayList<>();
        try (PrintWriter writer= new PrintWriter("C:\\GIT\\jdbc-connection\\src\\ReadFileWriteDatabase\\write.csv")){
            for (Fruits fruitsList: fruitsArrayList) {
                if (fruitsList instanceof PartTimeEmployee){
                    fruitsList.setSalary(30);
                }
                writer.println(employee);
            }
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }*/

        /*SelectFruits fruits = new SelectFruits();
        fruits.selectAllFruits();*/
    }
}
