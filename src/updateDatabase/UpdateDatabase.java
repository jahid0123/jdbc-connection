package updateDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDatabase extends Oracle {

    public void updateStudentData(Student student) {

//        String updateStudent = "UPDATE studentjdbc SET STUDENTNAME = ? WHERE ID = ?";
        String updateStudent = "UPDATE studentjdbc SET STUDENTNAME = ? WHERE ID = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(updateStudent)) {

            statement.setString(1, student.getName());
            statement.setInt(2, student.getId());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Student updated successfully");
            } else {
                System.out.println("No student found with this given ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
