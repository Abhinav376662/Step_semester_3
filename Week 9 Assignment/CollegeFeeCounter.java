import java.util.*;

abstract class Student {
    protected String name;

    Student(String name) {
        this.name = name;
    }

    abstract double tuitionFee();

    double totalFee() {
        double fee = tuitionFee();

        if (this instanceof BusUser) {
            fee += ((BusUser) this).transportFee();
        }

        return fee;
    }
}

interface BusUser {
    double TRANSPORT_FEE = 12000;

    default double transportFee() {
        return TRANSPORT_FEE;
    }
}

class DayScholar extends Student implements BusUser {
    DayScholar(String name) {
        super(name);
    }

    double tuitionFee() {
        return 40000;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double tuitionFee() {
        return 40000 + 60000;
    }
}

class ScholarshipStudent extends Student implements BusUser {
    ScholarshipStudent(String name) {
        super(name);
    }

    double tuitionFee() {
        return 20000;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Student> students = new ArrayList<>();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0].toUpperCase();
            String name = parts[1];

            if (type.equals("DAY_SCHOLAR")) {
                students.add(new DayScholar(name));
            } else if (type.equals("HOSTELLER")) {
                students.add(new Hosteller(name));
            } else {
                students.add(new ScholarshipStudent(name));
            }
        }

        for (Student s : students) {
            double fee = s.totalFee();
            total += fee;
            System.out.printf("%s: %.2f%n", s.name, fee);
        }

        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}
