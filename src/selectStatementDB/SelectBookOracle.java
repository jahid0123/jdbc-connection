package selectStatementDB;

import java.sql.*;

public class SelectBookOracle extends Oracle{

    public void selectAllBooks() {
        String selectQuery = "SELECT * FROM BOOK";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectQuery)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String author = resultSet.getString("author");
                String genre = resultSet.getString("genre");
                double price = resultSet.getDouble("price");
                Date date = resultSet.getDate("publish");

                System.out.println("ID: "+id+", Name: "+name+", Author: "+author+", Genre: "+genre+", Price: "+price+", Publish Date: "+date);
            }
        } catch (SQLException e) {
            System.out.println("Error selecting data: " + e.getMessage());
        }
    }
}
