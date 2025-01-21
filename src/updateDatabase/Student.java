package updateDatabase;

public class Student {
    private String name;
    private int id;
    private int age;
    private String email;

    public Student(String name, int id, int age, String email) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }
}
