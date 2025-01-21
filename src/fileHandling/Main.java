package fileHandling;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String inputPath = "C:\\GIT\\jdbc-connection\\src\\fileHandling\\data.csv";
        ReadFile readFile = new ReadFile(inputPath);
        readFile.readFile();
        List<String[]> inputfile = readFile.getStringList();


        InsertData insertData = new InsertData();
        insertData.insertAllFruits(inputfile);

        RetriveData retriveData = new RetriveData();
        retriveData.selectAllFruits();
        List<String[]> readData=retriveData.getArrayString();

        for (String[] data: readData){
            if (data[0].equalsIgnoreCase("1")){
                data[2] = "Hemel";
                data[3] =  "Ashik";
            }

            /*data[2] = "Hemel";
            data[3] =  "Ashik";*/
        }


        String filePath2 = "C:\\GIT\\jdbc-connection\\src\\fileHandling\\write.csv";
        WriteFile writeFile = new WriteFile(filePath2, readData);
        writeFile.writeFile();
    }

}
