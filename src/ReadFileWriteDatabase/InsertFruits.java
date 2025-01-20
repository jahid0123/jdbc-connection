package ReadFileWriteDatabase;

import java.sql.*;

public class InsertFruits extends Oracle {


    public void insertDummyData(String[][] fruits ){
        String insertQuery = "INSERT INTO FRUITS(name, buyer, seller, price, buydate, selldate) values (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)){

            for (String[] fruit: fruits){
                preparedStatement.setString(1, fruit[1]);
                preparedStatement.setString(2, fruit[2]);
                preparedStatement.setString(3, fruit[3]);
                preparedStatement.setDouble(4, Double.parseDouble(fruit[4]));
                preparedStatement.setDate(5, Date.valueOf(fruit[5]));
                preparedStatement.setDate(6, Date.valueOf(fruit[6]));

                preparedStatement.addBatch();
            }
            int[] rowsInserted = preparedStatement.executeBatch();
            System.out.println("Rows inserted: "+ rowsInserted.length);
        } catch (SQLException e) {
            System.out.println("Error inserting data: "+e.getMessage());
        }
    }
}
