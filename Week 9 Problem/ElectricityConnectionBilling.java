import java.util.*;

abstract class Connection {
    protected double units;

    Connection(double units) {
        this.units = units;
    }

    abstract double calculateBill();
}

class HomeConnection extends Connection {
    HomeConnection(double units) {
        super(units);
    }

    double calculateBill() {
        if (units <= 100) {
            return units * 5;
        }
        return (100 * 5) + ((units - 100) * 7);
    }
}

class ShopConnection extends Connection {
    ShopConnection(double units) {
        super(units);
    }

    double calculateBill() {
        return (units * 8) + 100;
    }
}

class FactoryConnection extends Connection {
    FactoryConnection(double units) {
        super(units);
    }

    double calculateBill() {
        return Math.max(units * 6, 1000);
    }
}

public class ElectricityConnectionBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Connection> connections = new ArrayList<>();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0].toUpperCase();
            double units = Double.parseDouble(parts[1]);

            if (type.equals("HOME")) {
                connections.add(new HomeConnection(units));
            } else if (type.equals("SHOP")) {
                connections.add(new ShopConnection(units));
            } else if (type.equals("FACTORY")) {
                connections.add(new FactoryConnection(units));
            }
        }

        String[] typeNames = {"HOME", "SHOP", "FACTORY"};

        for (Connection c : connections) {
            double bill = c.calculateBill();
            total += bill;

            String typeName;
            if (c instanceof HomeConnection) {
                typeName = "HOME";
            } else if (c instanceof ShopConnection) {
                typeName = "SHOP";
            } else {
                typeName = "FACTORY";
            }

            System.out.printf("%s: %.2f%n", typeName, bill);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
