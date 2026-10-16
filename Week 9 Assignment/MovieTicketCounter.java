import java.util.*;

abstract class Ticket {
    protected int count;
    private static final double CONVENIENCE_FEE = 20;

    Ticket(int count) {
        this.count = count;
    }

    abstract double pricePerTicket();

    double amount() {
        return count * (pricePerTicket() + CONVENIENCE_FEE);
    }
}

class RegularTicket extends Ticket {
    RegularTicket(int count) {
        super(count);
    }

    double pricePerTicket() {
        return 150;
    }
}

class PremiumTicket extends Ticket {
    PremiumTicket(int count) {
        super(count);
    }

    double pricePerTicket() {
        return 250;
    }
}

class ReclinerTicket extends Ticket {
    ReclinerTicket(int count) {
        super(count);
    }

    double pricePerTicket() {
        return 400;
    }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Ticket> tickets = new ArrayList<>();
        List<String> seatNames = new ArrayList<>();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String seat = parts[0].toUpperCase();
            int count = Integer.parseInt(parts[1]);

            if (seat.equals("REGULAR")) {
                tickets.add(new RegularTicket(count));
            } else if (seat.equals("PREMIUM")) {
                tickets.add(new PremiumTicket(count));
            } else {
                tickets.add(new ReclinerTicket(count));
            }
            seatNames.add(seat);
        }

        for (int i = 0; i < tickets.size(); i++) {
            double amount = tickets.get(i).amount();
            total += amount;
            System.out.printf("%s: %.2f%n", seatNames.get(i), amount);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
