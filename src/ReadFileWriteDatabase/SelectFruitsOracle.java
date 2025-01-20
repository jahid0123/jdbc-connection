package ReadFileWriteDatabase;

import selectStatementDB.Oracle;

import java.sql.*;

public class SelectFruitsOracle extends Oracle {

    public void selectAllBooks() {
        String selectQuery = "SELECT * FROM FRUITS";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectQuery)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String buyer = resultSet.getString("buyer");
                String seller = resultSet.getString("seller");
                double price = resultSet.getDouble("price");
                Date buyDate = resultSet.getDate("buydate");
                Date sellDate = resultSet.getDate("selldate");

                System.out.println("ID: "+id+", Name: "+name+", Buyer: "+buyer+", Seller: "+seller+", Price: "+price+", Buy Date: "+buyDate+", Sell Date: "+sellDate);
            }
        } catch (SQLException e) {
            System.out.println("Error selecting data: " + e.getMessage());
        }
    }
}
