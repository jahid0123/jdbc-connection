package ReadFileWriteDatabase.employeeManagementSystem;

public class PartTimeEmployee extends Employee{



    public PartTimeEmployee(String name, int id, double salary) throws InvalidSalaryException {
        super(name, id, salary);
        if (salary<=0){
            throw new InvalidSalaryException("Invalid salary");
        }

    }

    @Override
    public double taxCalculator() {
        return 0;
    }

    @Override
    public String toString() {
        return "Name: "+getName()+" Id: "+getId()+" Salary: "+getSalary()+ " Tax: "+ taxCalculator()+" Type: PartTime";
    }
}
