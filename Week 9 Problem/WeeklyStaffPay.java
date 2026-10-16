import java.util.*;

abstract class Staff {
    protected String name;

    Staff(String name) {
        this.name = name;
    }

    abstract double calculatePay();
}

class FullTimeStaff extends Staff {
    private double weeklySalary;

    FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    double calculatePay() {
        return weeklySalary;
    }
}

class HourlyStaff extends Staff {
    private double hours, rate;

    HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        }
        return (40 * rate) + ((hours - 40) * rate * 1.5);
    }
}

class InternStaff extends Staff {
    private double stipend;

    InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    double calculatePay() {
        return stipend;
    }
}

public class WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Staff> staffList = new ArrayList<>();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0].toUpperCase();
            String name = parts[1];

            if (type.equals("FULLTIME")) {
                staffList.add(new FullTimeStaff(name, Double.parseDouble(parts[2])));
            } else if (type.equals("HOURLY")) {
                staffList.add(new HourlyStaff(name,
                        Double.parseDouble(parts[2]),
                        Double.parseDouble(parts[3])));
            } else if (type.equals("INTERN")) {
                staffList.add(new InternStaff(name, Double.parseDouble(parts[2])));
            }
        }

        for (Staff s : staffList) {
            double pay = s.calculatePay();
            total += pay;
            System.out.printf("%s: %.2f%n", s.name, pay);
        }

        System.out.printf("Total Payroll: %.2f%n", total);
        sc.close();
    }
}
