package ReadFileWriteDatabase.employeeManagementSystem;

public class FullTimeEmployee extends Employee{

    public FullTimeEmployee(String name, int id, double salary ) throws InvalidSalaryException {
        super(name, id, salary);
        if (salary<=0){
            throw new InvalidSalaryException("Invalid salary");
        }

    }

    @Override
    public double taxCalculator() {
        double TAX_RATE = (double) 5 /100;
        return getSalary()* TAX_RATE;
    }

    @Override
    public String toString() {
        return "Name: "+getName()+" Id: "+getId()+" Salary: "+getSalary()+ " Tax: "+ taxCalculator()+" Type: FullTime";
    }
}
