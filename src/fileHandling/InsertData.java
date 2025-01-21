package fileHandling;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InsertData extends Oracle {

    public void insertAllFruits(List<String[]> fruits) {

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String insertQuery = "INSERT INTO FRUITS(name, buyer, seller, price, buydate, selldate) values (?, ?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), TO_DATE(?, 'YYYY-MM-DD'))";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                for (String[] row : fruits) {

                    preparedStatement.setString(1, row[1]);
                    preparedStatement.setString(2, row[2]);
                    preparedStatement.setString(3, row[3]);
                    preparedStatement.setDouble(4, Double.parseDouble(row[4]));
                    preparedStatement.setString(5, row[5]);
                    preparedStatement.setString(6, row[6]);
                    preparedStatement.executeUpdate();
                }
            }

            System.out.println("Data insert into database");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
