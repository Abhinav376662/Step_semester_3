import java.util.HashMap;
import java.util.Scanner;

public class FirstNonRepeatingChar {
    
    public static char findFirstNonRepeatingChar(String text) {
        HashMap<Character, Integer> frequency = new HashMap<>();
        
        // Count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }
        
        // Find first character with frequency = 1
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (frequency.get(ch) == 1) {
                return ch;
            }
        }
        
        return '\0'; // No non-repeating character
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a word or sentence: ");
        String text = sc.nextLine();
        
        char result = findFirstNonRepeatingChar(text);
        
        System.out.println("\n=== Unique Letter Hunt Result ===");
        if (result != '\0') {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        } else {
            System.out.println("No Non-Repeating Character Found");
        }
        
        sc.close();
    }
}
