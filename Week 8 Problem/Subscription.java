import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

abstract class Subscription {
    protected String name;
    protected LocalDate startDate;
    
    public Subscription(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }
    
    public abstract LocalDate getRenewalDate();
    public String getName() {
        return name;
    }
}

class BasicPlan extends Subscription {
    public BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }
    
    @Override
    public LocalDate getRenewalDate() {
        return startDate.plusDays(30); // 30 days validity
    }
}

class StandardPlan extends Subscription {
    public StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }
    
    @Override
    public LocalDate getRenewalDate() {
        return startDate.plusDays(90); // 90 days validity
    }
}

class PremiumPlan extends Subscription {
    public PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }
    
    @Override
    public LocalDate getRenewalDate() {
        return startDate.plusDays(365); // 365 days validity
    }
}

public class StreamingRenewal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        Subscription[] subscribers = new Subscription[n];
        
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            String dateStr = sc.next();
            
            LocalDate startDate = LocalDate.parse(dateStr);
            
            if (type.equals("BASIC")) {
                subscribers[i] = new BasicPlan(name, startDate);
            } else if (type.equals("STANDARD")) {
                subscribers[i] = new StandardPlan(name, startDate);
            } else if (type.equals("PREMIUM")) {
                subscribers[i] = new PremiumPlan(name, startDate);
            }
        }
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        for (Subscription s : subscribers) {
            System.out.printf("%s: %s%n", s.getName(), 
                s.getRenewalDate().format(formatter));
        }
        
        sc.close();
    }
}
