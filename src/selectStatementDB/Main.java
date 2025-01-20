package selectStatementDB;

public class Main {
    public static void main(String[] args) {

        SelectStudentOracle oracle= new SelectStudentOracle();
        oracle.selectAllStudents();
        System.out.println();

        SelectBookOracle oracle1 = new SelectBookOracle();
        oracle1.selectAllBooks();
    }
}
