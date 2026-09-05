import java.util.Scanner;

public class SeatDuplicationChecker {
    
    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean duplicateFound = false;
        
        System.out.println("\n=== Exam Hall Seat Duplication Check ===\n");
        
        // Compare every seat number against every other seat number
        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    duplicateFound = true;
                }
            }
        }
        
        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of seats: ");
        int n = sc.nextInt();
        
        int[] seatNumbers = new int[n];
        
        System.out.println("Enter " + n + " seat numbers:");
        for (int i = 0; i < n; i++) {
            seatNumbers[i] = sc.nextInt();
        }
        
        checkDuplicateSeats(seatNumbers);
        
        sc.close();
    }
}
