import java.util.*;

abstract class TravelBooking {
    protected double distanceKm;
    private static final double BOOKING_FEE = 50;

    TravelBooking(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    abstract double calculateFare();

    double calculateTotal() {
        return calculateFare() + BOOKING_FEE;
    }
}

class BusBooking extends TravelBooking {
    BusBooking(double distanceKm) {
        super(distanceKm);
    }

    double calculateFare() {
        return distanceKm * 2;
    }
}

class TrainBooking extends TravelBooking {
    TrainBooking(double distanceKm) {
        super(distanceKm);
    }

    double calculateFare() {
        return distanceKm * 1.5;
    }
}

class FlightBooking extends TravelBooking {
    FlightBooking(double distanceKm) {
        super(distanceKm);
    }

    double calculateFare() {
        return 2500 + (distanceKm * 4);
    }
}

public class TravelBookingWithCommonFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<TravelBooking> bookings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String mode = parts[0].toUpperCase();
            double distance = Double.parseDouble(parts[1]);

            if (mode.equals("BUS")) {
                bookings.add(new BusBooking(distance));
            } else if (mode.equals("TRAIN")) {
                bookings.add(new TrainBooking(distance));
            } else if (mode.equals("FLIGHT")) {
                bookings.add(new FlightBooking(distance));
            }
        }

        for (TravelBooking b : bookings) {
            String modeName;
            if (b instanceof BusBooking) {
                modeName = "BUS";
            } else if (b instanceof TrainBooking) {
                modeName = "TRAIN";
            } else {
                modeName = "FLIGHT";
            }

            System.out.printf("%s: %.2f%n", modeName, b.calculateTotal());
        }

        sc.close();
    }
}
