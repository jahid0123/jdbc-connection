import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertStudentPostgre {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "isdb62";

    public void insertDummyData(String[][] students ){
        String insertQuery = "INSERT INTO studentjdbc(name, age, email) values (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)){

            for (String[] student: students){
                preparedStatement.setString(1, student[0]);
                preparedStatement.setInt(2, Integer.parseInt(student[1]));
                preparedStatement.setString(3, student[2]);

                preparedStatement.addBatch();
            }
            int[] rowsInserted = preparedStatement.executeBatch();
            System.out.println("Rows inserted: "+ rowsInserted.length);
        } catch (SQLException e) {
            System.out.println("Error inserting data: "+e.getMessage());
        }
    }
}
