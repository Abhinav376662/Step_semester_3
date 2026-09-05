import java.util.Scanner;

public class PinValidator {
    
    public static void checkPinLength(String pin) {
        System.out.println("\n=== ATM PIN Validator ===\n");
        
        int length = pin.length();
        
        if (length != 4) {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter PIN: ");
        String pin = sc.nextLine();
        
        checkPinLength(pin);
        
        sc.close();
    }
}
