import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String inputCsvFile = "C:\\GIT\\jdbc-connection\\src\\fileHandling\\data.csv";
        String outputCsvFile = "C:\\GIT\\jdbc-connection\\src\\fileHandling\\write.csv";

        String dbUrl = "jdbc:oracle:thin:@//localhost:1521/ORCLPDB";
        String dbUsername = "orclpdbuser";
        String dbPassword = "isdb62";

        List<String[]> csvData = new ArrayList<>();

        // Step 1: Read data from the CSV file
        try (BufferedReader br = new BufferedReader(new FileReader(inputCsvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                csvData.add(line.split(","));
            }
            System.out.println("Data read from CSV file.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Step 2: Insert data into the database
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) {
            String insertQuery = "INSERT INTO fruits (id, name, buyer, seller, price, buydate, selldate) " +
                    "VALUES (?, ?, ?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), TO_DATE(?, 'YYYY-MM-DD'))";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                for (String[] row : csvData) {
                    preparedStatement.setInt(1, Integer.parseInt(row[0]));
                    preparedStatement.setString(2, row[1]);
                    preparedStatement.setString(3, row[2]);
                    preparedStatement.setString(4, row[3]);
                    preparedStatement.setDouble(5, Double.parseDouble(row[4]));
                    preparedStatement.setString(6, row[5]);
                    preparedStatement.setString(7, row[6]);
                    preparedStatement.executeUpdate();
                }
                System.out.println("Data inserted into the database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Step 3: Read data back from the database
        List<String[]> dbData = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) {
            String selectQuery = "SELECT * FROM fruits";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(selectQuery)) {
                while (resultSet.next()) {
                    String[] row = new String[7];
                    row[0] = String.valueOf(resultSet.getInt("id"));
                    row[1] = resultSet.getString("name");
                    row[2] = resultSet.getString("buyer");
                    row[3] = resultSet.getString("seller");
                    row[4] = String.valueOf(resultSet.getDouble("price"));
                    row[5] = resultSet.getDate("buydate").toString();
                    row[6] = resultSet.getDate("selldate").toString();
                    dbData.add(row);
                }
                System.out.println("Data read from the database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Step 4: Write data to a new CSV file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputCsvFile))) {
            for (String[] row : dbData) {
                bw.write(String.join(",", row));
                bw.newLine();
            }
            System.out.println("Data written to " + outputCsvFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
