package ReadFileWriteDatabase.employeeManagementSystem;

import ReadFileWriteDatabase.SelectFruits;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

      /*  List<Employee> employees = new ArrayList<>();

        try(Scanner inputPath = new Scanner(new File("C:\\GIT\\learning-java\\employee_details.csv"))){

            while (inputPath.hasNextLine()){
                String[] data = inputPath.nextLine().split(",");
                String name = data[0].trim();
                int id =Integer.parseInt(data[1].trim());
                double salary = Double.parseDouble(data[2].trim());
                String type = data[3].trim();

                if (type.equalsIgnoreCase("FullTime")){
                    employees.add(new FullTimeEmployee(name, id, salary));
                } else if (type.equalsIgnoreCase("PartTime")) {
                    employees.add(new PartTimeEmployee(name, id, salary));
                } else if (type.equalsIgnoreCase("Contract")) {
                    employees.add(new ContractEmployee(name, id, salary));

                }
            }
        }catch (FileNotFoundException | InvalidSalaryException e){
            System.out.println(e.getMessage());
        }



        try (PrintWriter writer= new PrintWriter("C:\\GIT\\learning-java\\employee_details_update")){
            for (Employee employee: employees) {
                if (employee instanceof PartTimeEmployee){
                    employee.setSalary(30);
                }
                writer.println(employee);
            }
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }*/

        SelectFruits fruits = new SelectFruits();
        fruits.selectAllFruits();
    }
}
