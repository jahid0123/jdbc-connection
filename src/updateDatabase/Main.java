package updateDatabase;

public class Main {

    public static void main(String[] args) {
        Student student = new Student("Ihan Ahmed", 4, 1, "ihan123@gmail.com");

        UpdateDatabase database = new UpdateDatabase();
        database.updateStudentData(student);
    }
}
