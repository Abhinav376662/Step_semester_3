import java.util.*;

abstract class Appliance {
    protected double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double powerWatts();

    double units() {
        return (powerWatts() * hours) / 1000;
    }

    double cost() {
        return units() * 8;
    }
}

interface SaverMode {
    double reducedUnits(double normalUnits);
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours);
    }

    double powerWatts() {
        return 150;
    }
}

class AirConditioner extends Appliance implements SaverMode {
    AirConditioner(double hours) {
        super(hours);
    }

    double powerWatts() {
        return 1500;
    }

    public double reducedUnits(double normalUnits) {
        return normalUnits * 0.75;
    }
}

class Television extends Appliance {
    Television(double hours) {
        super(hours);
    }

    double powerWatts() {
        return 100;
    }
}

class WashingMachine extends Appliance implements SaverMode {
    WashingMachine(double hours) {
        super(hours);
    }

    double powerWatts() {
        return 500;
    }

    public double reducedUnits(double normalUnits) {
        return normalUnits * 0.75;
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Appliance> appliances = new ArrayList<>();
        List<String> names = new ArrayList<>();
        List<Boolean> saverRequested = new ArrayList<>();
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String appliance = parts[0].toUpperCase();
            double hours = Double.parseDouble(parts[1]);
            boolean saver = parts.length > 2 && parts[2].equalsIgnoreCase("SAVER");

            if (appliance.equals("FRIDGE")) {
                appliances.add(new Fridge(hours));
            } else if (appliance.equals("AC")) {
                appliances.add(new AirConditioner(hours));
            } else if (appliance.equals("TV")) {
                appliances.add(new Television(hours));
            } else {
                appliances.add(new WashingMachine(hours));
            }

            names.add(appliance);
            saverRequested.add(saver);
        }

        for (int i = 0; i < appliances.size(); i++) {
            Appliance a = appliances.get(i);
            String name = names.get(i);
            boolean saver = saverRequested.get(i);

            if (saver && !(a instanceof SaverMode)) {
                System.out.printf("%s: saver mode not supported%n", name);
                continue;
            }

            double units = a.units();
            if (saver) {
                units = ((SaverMode) a).reducedUnits(units);
            }

            double cost = units * 8;
            totalCost += cost;

            System.out.printf("%s: Units=%.2f Cost=%.2f%n", name, units, cost);
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}
