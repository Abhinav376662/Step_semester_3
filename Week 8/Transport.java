import java.util.Scanner;

abstract class Transport {
    protected double distance;
    
    public Transport(double distance) {
        this.distance = distance;
    }
    
    public abstract double calculateFare();
    public abstract String getType();
}

class Bus extends Transport {
    public Bus(double distance) {
        super(distance);
    }
    
    @Override
    public double calculateFare() {
        double fare = 2 + (0.10 * distance);
        return Math.min(fare, 10); // Max fare $10
    }
    
    @Override
    public String getType() {
        return "BUS";
    }
}

class Train extends Transport {
    public Train(double distance) {
        super(distance);
    }
    
    @Override
    public double calculateFare() {
        return 3 + (0.15 * distance);
    }
    
    @Override
    public String getType() {
        return "TRAIN";
    }
}

class Metro extends Transport {
    private double peakHourFactor;
    
    public Metro(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }
    
    @Override
    public double calculateFare() {
        return (1.50 + (0.20 * distance)) * peakHourFactor;
    }
    
    @Override
    public String getType() {
        return "METRO";
    }
}

public class TransportSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        Transport[] transports = new Transport[n];
        double total = 0;
        
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            
            if (type.equals("BUS")) {
                double distance = sc.nextDouble();
                transports[i] = new Bus(distance);
            } else if (type.equals("TRAIN")) {
                double distance = sc.nextDouble();
                transports[i] = new Train(distance);
            } else if (type.equals("METRO")) {
                double distance = sc.nextDouble();
                double peakFactor = sc.nextDouble();
                transports[i] = new Metro(distance, peakFactor);
            }
        }
        
        for (Transport t : transports) {
            double fare = t.calculateFare();
            total += fare;
            System.out.printf("%s: %.2f%n", t.getType(), fare);
        }
        
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
