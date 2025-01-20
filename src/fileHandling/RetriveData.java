package fileHandling;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RetriveData extends Oracle{

    private ArrayList<String[]> arrayString = new ArrayList<>();



    public void selectAllFruits(){

        String selectQuery = "SELECT * FROM FRUITS";

        try(Connection collection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = collection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectQuery)) {

            while (resultSet.next()) {
                String [] row = new String[7];
                row[0] = String.valueOf(resultSet.getInt("id"));
                row[1] = String.valueOf(resultSet.getString("name"));
                row[2] = String.valueOf(resultSet.getString("buyer"));
                row[3] = String.valueOf(resultSet.getString("seller"));
                row[4] = String.valueOf(resultSet.getDouble("price"));
                row[5] = String.valueOf(resultSet.getDate("buyDate"));
                row[6] = String.valueOf(resultSet.getDate("buyDate"));
                arrayString.add(row);
            }

            System.out.println("Data select from database");

        } catch (SQLException e) {
            System.out.println("Error "+e.getMessage());;
        }
    }

    public ArrayList<String[]> getArrayString() {
        return arrayString;
    }
}
