package insertData;

public class Main {
    public static void main(String[] args) {

        /*String [][] students = {
                {"Jahid Ahmed", "29", "ajahid@gmail.com"},
                {"Mahim Ahmed", "27", "ajahid@gmail.com"},
                {"Pranto Ahmed", "11", "ajahid@gmail.com"},
                {"Tamim Ahmed", "8", "ajahid@gmail.com"},
        };*/

        String [][] books = {
                {"Bangla", "Professor", "", "500.12", "2025-01-10"},
                {"English", "Nahid", "", "600.12", "2025-01-11"},
                {"Science", "Hemel", "", "700.12", "2025-01-12"},
                {"Math", "Ashik", "", "300.12", "2025-01-15"},

        };

        /*insertData.InsertStudentOracle oracle = new insertData.InsertStudentOracle();
        oracle.insertDummyData(students);*/

        /*insertData.InsertStudentPostgre postgre = new insertData.InsertStudentPostgre();
        postgre.insertDummyData(students);*/

        BookOracle bookOracle = new BookOracle();
        bookOracle.insertDummyData(books);
    }
}