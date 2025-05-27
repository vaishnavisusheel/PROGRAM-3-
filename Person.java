import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Person {
    protected String name;

    public Person(String name) {
        this.name = name;
    }

    public void displayPersonName() {
        System.out.println("Name: " + name);
    }

    public void displayAge(String dob) {
        DateTimeFormatter formatter;

        if (dob.charAt(2) == '-') {
            formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        } else {
            formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        }

        LocalDate birthDate = LocalDate.parse(dob, formatter);
        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(birthDate, currentDate);

        System.out.println("Age: " + age.getYears() + " years");
    }
    class Employee extends Person {
    private String empId;
    private double salary;

    public Employee(String name, String empId, double salary) {
        super(name);
        this.empId = empId;
        this.salary = salary;
    }

    public void displayEmployeeDetails(String dob) {
        displayPersonName();
        displayAge(dob);
        System.out.println("Employee ID: " + empId);
        System.out.println("Salary: ₹" + salary);
    }
    }
}