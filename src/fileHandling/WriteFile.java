package fileHandling;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteFile {
    private String filePath;
    private List<String[]> arrayString = new ArrayList<>();

    public WriteFile(String filePath, List<String[]> arrayString) {
        this.filePath = filePath;
        this.arrayString = arrayString;
    }

    public void writeFile(){

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
            for (String[] row: arrayString){
                writer.write(String.join(",", row));
                writer.newLine();

            }
            System.out.println("File write successfully");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
