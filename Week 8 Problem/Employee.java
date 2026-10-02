import java.util.Scanner;

abstract class Employee {
    protected String name;
    protected double monthlySalary;
    
    public Employee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }
    
    public abstract double getBonus();
    public String getName() {
        return name;
    }
}

class FullTime extends Employee {
    public FullTime(String name, double monthlySalary) {
        super(name, monthlySalary);
    }
    
    @Override
    public double getBonus() {
        return monthlySalary * 0.10; // 10% of salary
    }
}

class PartTime extends Employee {
    public PartTime(String name, double monthlySalary) {
        super(name, monthlySalary);
    }
    
    @Override
    public double getBonus() {
        return monthlySalary * 0.05; // 5% of salary
    }
}

class Intern extends Employee {
    public Intern(String name, double monthlySalary) {
        super(name, monthlySalary);
    }
    
    @Override
    public double getBonus() {
        return 2000; // Fixed ₹2000
    }
}

public class FestivalBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        Employee[] employees = new Employee[n];
        double totalBonus = 0;
        
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();
            
            if (type.equals("FULLTIME")) {
                employees[i] = new FullTime(name, salary);
            } else if (type.equals("PARTTIME")) {
                employees[i] = new PartTime(name, salary);
            } else if (type.equals("INTERN")) {
                employees[i] = new Intern(name, salary);
            }
        }
        
        for (Employee e : employees) {
            double bonus = e.getBonus();
            totalBonus += bonus;
            System.out.printf("%s: %.2f%n", e.getName(), bonus);
        }
        
        System.out.printf("Total Bonus: %.2f%n", totalBonus);
        sc.close();
    }
}
