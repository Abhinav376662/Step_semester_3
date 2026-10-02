import java.util.Scanner;

abstract class Vehicle {
    protected int hours;
    
    public Vehicle(int hours) {
        this.hours = hours;
    }
    
    public abstract double getCharge();
    public abstract String getType();
}

class Bike extends Vehicle {
    public Bike(int hours) {
        super(hours);
    }
    
    @Override
    public double getCharge() {
        return 10 * hours; // ₹10 per hour
    }
    
    @Override
    public String getType() {
        return "BIKE";
    }
}

class Car extends Vehicle {
    public Car(int hours) {
        super(hours);
    }
    
    @Override
    public double getCharge() {
        return 30 + (20 * (hours - 1)); // ₹30 first hour, ₹20 each additional
    }
    
    @Override
    public String getType() {
        return "CAR";
    }
}

class Truck extends Vehicle {
    public Truck(int hours) {
        super(hours);
    }
    
    @Override
    public double getCharge() {
        double charge = 50 * hours;
        return Math.max(charge, 100); // Minimum ₹100
    }
    
    @Override
    public String getType() {
        return "TRUCK";
    }
}

public class ParkingCharge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        Vehicle[] vehicles = new Vehicle[n];
        double total = 0;
        
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();
            
            if (type.equals("BIKE")) {
                vehicles[i] = new Bike(hours);
            } else if (type.equals("CAR")) {
                vehicles[i] = new Car(hours);
            } else if (type.equals("TRUCK")) {
                vehicles[i] = new Truck(hours);
            }
        }
        
        for (Vehicle v : vehicles) {
            double charge = v.getCharge();
            total += charge;
            System.out.printf("%s: %.2f%n", v.getType(), charge);
        }
        
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
