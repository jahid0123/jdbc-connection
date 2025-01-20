package fileHandling;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InsertData extends Oracle {

    public void insertAllFruits(List<String[]> fruits) {

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String insertQuery = "INSERT INTO FRUITS(id, name, buyer, seller, price, buydate, selldate) values (?, ?, ?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), TO_DATE(?, 'YYYY-MM-DD'))";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                for (String[] row : fruits) {
                    preparedStatement.setInt(1, Integer.parseInt(row[0]));
                    preparedStatement.setString(2, row[1]);
                    preparedStatement.setString(3, row[2]);
                    preparedStatement.setString(4, row[3]);
                    preparedStatement.setDouble(5, Double.parseDouble(row[4]));
                    preparedStatement.setString(6, row[5]);
                    preparedStatement.setString(7, row[6]);
                    preparedStatement.executeUpdate();
                }
            }

            System.out.println("Data insert into database");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
