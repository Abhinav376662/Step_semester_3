import java.util.*;

abstract class Parcel {
    protected double weightKg;
    protected double declaredValue;

    Parcel(double weightKg, double declaredValue) {
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    abstract double shippingCharge();
}

interface Insurable {
    double insurance();
}

class StandardParcel extends Parcel {
    StandardParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    double shippingCharge() {
        return 40 + (weightKg * 10);
    }
}

class ExpressParcel extends Parcel implements Insurable {
    ExpressParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    double shippingCharge() {
        return 80 + (weightKg * 15);
    }

    public double insurance() {
        return declaredValue * 0.02;
    }
}

class FragileParcel extends Parcel implements Insurable {
    FragileParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    double shippingCharge() {
        return 40 + (weightKg * 10) + 50;
    }

    public double insurance() {
        return declaredValue * 0.02;
    }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Parcel> parcels = new ArrayList<>();
        List<String> typeNames = new ArrayList<>();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0].toUpperCase();
            double weight = Double.parseDouble(parts[1]);
            double value = Double.parseDouble(parts[2]);

            if (type.equals("STANDARD")) {
                parcels.add(new StandardParcel(weight, value));
            } else if (type.equals("EXPRESS")) {
                parcels.add(new ExpressParcel(weight, value));
            } else {
                parcels.add(new FragileParcel(weight, value));
            }
            typeNames.add(type);
        }

        for (int i = 0; i < parcels.size(); i++) {
            Parcel p = parcels.get(i);
            double charge = p.shippingCharge();
            double insurance = 0;

            if (p instanceof Insurable) {
                insurance = ((Insurable) p).insurance();
            }

            double parcelTotal = charge + insurance;
            grandTotal += parcelTotal;

            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    typeNames.get(i), charge, insurance, parcelTotal);
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}
