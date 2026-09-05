import java.util.Scanner;

public class TypingAccuracyChecker {
    
    public static void checkTypingAccuracy(String original, String typed) {
        System.out.println("\n=== Typing Speed Test Accuracy Check ===\n");
        
        if (original.length() != typed.length()) {
            System.out.println("Error: Strings must be of equal length!");
            return;
        }
        
        int matched = 0;
        int firstMismatchPos = -1;
        char originalChar = ' ', typedChar = ' ';
        
        // Compare character by character
        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else {
                if (firstMismatchPos == -1) {
                    firstMismatchPos = i + 1; // 1-based position
                    originalChar = original.charAt(i);
                    typedChar = typed.charAt(i);
                }
            }
        }
        
        double accuracy = (matched * 100.0) / original.length();
        
        System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | ", 
                         matched, original.length(), accuracy);
        
        if (firstMismatchPos == -1) {
            System.out.println("No Mismatches");
        } else {
            System.out.printf("First Mismatch at position %d ('%c' vs '%c')%n", 
                            firstMismatchPos, originalChar, typedChar);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter original passage: ");
        String original = sc.nextLine();
        
        System.out.print("Enter typed text: ");
        String typed = sc.nextLine();
        
        checkTypingAccuracy(original, typed);
        
        sc.close();
    }
}
