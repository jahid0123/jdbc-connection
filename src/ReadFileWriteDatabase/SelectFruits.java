package ReadFileWriteDatabase;

import selectStatementDB.Oracle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SelectFruits extends Oracle {

    List<ArrayList<String>> fruitList = new ArrayList<>();
    ArrayList<String> fruit = new ArrayList<>();

    public void selectAllFruits() {
        String selectQuery = "SELECT * FROM Fruits";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectQuery)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String buyer = resultSet.getString("buyer");
                String seller = resultSet.getString("seller");
                double price = resultSet.getDouble("price");
                Date buyDate = resultSet.getDate("buyDate");
                Date sellDate = resultSet.getDate("buyDate");



                System.out.println("ID: "+id+", Name: "+name+", Buyer: "+buyer+", Seller: "+seller+", Price: "+price+", Buy Date: "+buyDate+"Sell Date"+sellDate);
            }


        } catch (SQLException e) {
            System.out.println("Error selecting data: " + e.getMessage());
        }


    }
}
