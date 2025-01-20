package fileHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

    private String arrayString;
    private List<String[]> stringList = new ArrayList<>();


    public ReadFile(String arrayString) {
        this.arrayString = arrayString;
    }

    public void readFile(){
        try(BufferedReader reader = new BufferedReader(new FileReader(arrayString))){
            String line;
            while ((line = reader.readLine()) != null){
                    stringList.add(line.split(","));
            }
            System.out.println("Data read from csv file");
        } catch (IOException e) {
            System.out.println("Error found"+e.getMessage());
        }
    }

    public List<String[]> getStringList() {
        return stringList;
    }
}
