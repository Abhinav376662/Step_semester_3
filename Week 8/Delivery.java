import java.util.Scanner;

abstract class Delivery {
    protected double weight;
    protected double distance;
    
    public Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }
    
    public abstract double calculateFee();
    public abstract String getType();
}

class StandardDelivery extends Delivery {
    public StandardDelivery(double weight, double distance) {
        super(weight, distance);
    }
    
    @Override
    public double calculateFee() {
        return 5 + (0.50 * weight) + (0.10 * distance);
    }
    
    @Override
    public String getType() {
        return "STANDARD";
    }
}

class ExpressDelivery extends Delivery {
    public ExpressDelivery(double weight, double distance) {
        super(weight, distance);
    }
    
    @Override
    public double calculateFee() {
        return 15 + (1.00 * weight) + (0.20 * distance);
    }
    
    @Override
    public String getType() {
        return "EXPRESS";
    }
}

class InternationalDelivery extends Delivery {
    private double customsFee;
    
    public InternationalDelivery(double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }
    
    @Override
    public double calculateFee() {
        return 25 + (2.00 * weight) + (0.50 * distance) + customsFee;
    }
    
    @Override
    public String getType() {
        return "INTERNATIONAL";
    }
}

public class DeliverySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        Delivery[] deliveries = new Delivery[n];
        double total = 0;
        
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            
            if (type.equals("STANDARD")) {
                double weight = sc.nextDouble();
                double distance = sc.nextDouble();
                deliveries[i] = new StandardDelivery(weight, distance);
            } else if (type.equals("EXPRESS")) {
                double weight = sc.nextDouble();
                double distance = sc.nextDouble();
                deliveries[i] = new ExpressDelivery(weight, distance);
            } else if (type.equals("INTERNATIONAL")) {
                double weight = sc.nextDouble();
                double distance = sc.nextDouble();
                double customsFee = sc.nextDouble();
                deliveries[i] = new InternationalDelivery(weight, distance, customsFee);
            }
        }
        
        for (Delivery d : deliveries) {
            double fee = d.calculateFee();
            total += fee;
            System.out.printf("%s: %.2f%n", d.getType(), fee);
        }
        
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
