import java.util.Scanner;

abstract class Room {
    protected int units;
    
    public Room(int units) {
        this.units = units;
    }
    
    public abstract double getBill();
    public abstract String getType();
}

class SingleRoom extends Room {
    public SingleRoom(int units) {
        super(units);
    }
    
    @Override
    public double getBill() {
        return 8 * units; // ₹8 per unit
    }
    
    @Override
    public String getType() {
        return "SINGLE";
    }
}

class SharedRoom extends Room {
    private int occupants;
    
    public SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }
    
    @Override
    public double getBill() {
        return (6 * units) / (double) occupants; // ₹6 per unit, split equally
    }
    
    @Override
    public String getType() {
        return "SHARED";
    }
}

class ACRoom extends Room {
    public ACRoom(int units) {
        super(units);
    }
    
    @Override
    public double getBill() {
        return (10 * units) + 200; // ₹10 per unit + ₹200 fixed
    }
    
    @Override
    public String getType() {
        return "AC";
    }
}

public class HostelElectricity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        Room[] rooms = new Room[n];
        double total = 0;
        
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            
            if (type.equals("SINGLE")) {
                int units = sc.nextInt();
                rooms[i] = new SingleRoom(units);
            } else if (type.equals("SHARED")) {
                int units = sc.nextInt();
                int occupants = sc.nextInt();
                rooms[i] = new SharedRoom(units, occupants);
            } else if (type.equals("AC")) {
                int units = sc.nextInt();
                rooms[i] = new ACRoom(units);
            }
        }
        
        for (Room r : rooms) {
            double bill = r.getBill();
            total += bill;
            System.out.printf("%s: %.2f%n", r.getType(), bill);
        }
        
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
