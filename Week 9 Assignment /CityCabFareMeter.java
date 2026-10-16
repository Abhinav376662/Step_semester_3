import java.util.*;

abstract class Cab {
    protected double distanceKm;

    Cab(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    abstract double ratePerKm();

    double fare() {
        double fare = distanceKm * ratePerKm();
        return Math.max(fare, 100);
    }
}

interface NightService {
    default double nightFare(double baseFare) {
        return baseFare * 1.20;
    }
}

class MiniCab extends Cab {
    MiniCab(double distanceKm) {
        super(distanceKm);
    }

    double ratePerKm() {
        return 10;
    }
}

class SedanCab extends Cab implements NightService {
    SedanCab(double distanceKm) {
        super(distanceKm);
    }

    double ratePerKm() {
        return 14;
    }
}

class SuvCab extends Cab implements NightService {
    SuvCab(double distanceKm) {
        super(distanceKm);
    }

    double ratePerKm() {
        return 18;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Cab> cabs = new ArrayList<>();
        List<String> cabNames = new ArrayList<>();
        List<String> times = new ArrayList<>();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String cabType = parts[0].toUpperCase();
            double km = Double.parseDouble(parts[1]);
            String time = parts[2].toUpperCase();

            if (cabType.equals("MINI")) {
                cabs.add(new MiniCab(km));
            } else if (cabType.equals("SEDAN")) {
                cabs.add(new SedanCab(km));
            } else {
                cabs.add(new SuvCab(km));
            }

            cabNames.add(cabType);
            times.add(time);
        }

        for (int i = 0; i < cabs.size(); i++) {
            Cab cab = cabs.get(i);
            String cabName = cabNames.get(i);
            String time = times.get(i);

            if (time.equals("NIGHT")) {
                if (cab instanceof NightService) {
                    double fare = ((NightService) cab).nightFare(cab.fare());
                    total += fare;
                    System.out.printf("%s: %.2f%n", cabName, fare);
                } else {
                    System.out.printf("%s: night service not available%n", cabName);
                }
            } else {
                double fare = cab.fare();
                total += fare;
                System.out.printf("%s: %.2f%n", cabName, fare);
            }
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
