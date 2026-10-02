import java.util.Scanner;

abstract class Customer {
    protected double amount;
    
    public Customer(double amount) {
        this.amount = amount;
    }
    
    public abstract double getFinalAmount();
    public abstract String getType();
}

class Student extends Customer {
    public Student(double amount) {
        super(amount);
    }
    
    @Override
    public double getFinalAmount() {
        return amount * 0.90; // 10% discount
    }
    
    @Override
    public String getType() {
        return "STUDENT";
    }
}

class Staff extends Customer {
    public Staff(double amount) {
        super(amount);
    }
    
    @Override
    public double getFinalAmount() {
        return amount * 0.95; // 5% discount
    }
    
    @Override
    public String getType() {
        return "STAFF";
    }
}

class Guest extends Customer {
    public Guest(double amount) {
        super(amount);
    }
    
    @Override
    public double getFinalAmount() {
        return amount + 10; // ₹10 service charge
    }
    
    @Override
    public String getType() {
        return "GUEST";
    }
}

public class CanteenBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        Customer[] customers = new Customer[n];
        double total = 0;
        
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            
            if (type.equals("STUDENT")) {
                customers[i] = new Student(amount);
            } else if (type.equals("STAFF")) {
                customers[i] = new Staff(amount);
            } else if (type.equals("GUEST")) {
                customers[i] = new Guest(amount);
            }
        }
        
        for (Customer c : customers) {
            double finalAmount = c.getFinalAmount();
            total += finalAmount;
            System.out.printf("%s: %.2f%n", c.getType(), finalAmount);
        }
        
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
