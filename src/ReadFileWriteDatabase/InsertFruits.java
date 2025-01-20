package ReadFileWriteDatabase;

import ReadFileWriteDatabase.fruits.Oracle;

import java.sql.*;

public class InsertFruits extends Oracle {


    public void insertDummyData(String[][] fruits ){
        String insertQuery = "INSERT INTO FRUITS(id, name, buyer, seller, price, buydate, selldate) values (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)){

            for (String[] fruit: fruits){
                preparedStatement.setInt(1, Integer.parseInt(fruit[0]));
                preparedStatement.setString(2, fruit[1]);
                preparedStatement.setString(3, fruit[2]);
                preparedStatement.setString(4, fruit[3]);
                preparedStatement.setDouble(5, Double.parseDouble(fruit[4]));
                preparedStatement.setDate(6, Date.valueOf(fruit[5]));
                preparedStatement.setDate(7, Date.valueOf(fruit[6]));

                preparedStatement.addBatch();
            }
            int[] rowsInserted = preparedStatement.executeBatch();
            System.out.println("Rows inserted: "+ rowsInserted.length);
        } catch (SQLException e) {
            System.out.println("Error inserting data: "+e.getMessage());
        }
    }
}
