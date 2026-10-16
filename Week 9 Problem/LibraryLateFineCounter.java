import java.util.*;

abstract class LibraryItem {
    protected String title;
    protected int daysLate;

    LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    abstract double calculateFine();
}

class Book extends LibraryItem {
    Book(String title, int daysLate) {
        super(title, daysLate);
    }

    double calculateFine() {
        return daysLate * 2;
    }
}

class DVD extends LibraryItem {
    DVD(String title, int daysLate) {
        super(title, daysLate);
    }

    double calculateFine() {
        return Math.min(daysLate * 5, 50);
    }
}

class Magazine extends LibraryItem {
    Magazine(String title, int daysLate) {
        super(title, daysLate);
    }

    double calculateFine() {
        return daysLate * 1;
    }
}

public class LibraryLateFineCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<LibraryItem> items = new ArrayList<>();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0].toUpperCase();
            String title = parts[1];
            int days = Integer.parseInt(parts[2]);

            if (type.equals("BOOK")) {
                items.add(new Book(title, days));
            } else if (type.equals("DVD")) {
                items.add(new DVD(title, days));
            } else if (type.equals("MAGAZINE")) {
                items.add(new Magazine(title, days));
            }
        }

        for (LibraryItem item : items) {
            double fine = item.calculateFine();
            total += fine;
            System.out.printf("%s: %.2f%n", item.title, fine);
        }

        System.out.printf("Total Fines: %.2f%n", total);
        sc.close();
    }
}
