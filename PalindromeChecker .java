import java.util.Scanner;

public class PalindromeChecker {
    
    // Approach 1: Iterative comparison
    public static boolean isPalindromeIterative(String text) {
        int left = 0, right = text.length() - 1;
        
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    // Approach 2: Recursive comparison
    public static boolean isPalindromeRecursive(String text) {
        return isPalindromeHelper(text, 0, text.length() - 1);
    }
    
    private static boolean isPalindromeHelper(String text, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (text.charAt(left) != text.charAt(right)) {
            return false;
        }
        return isPalindromeHelper(text, left + 1, right - 1);
    }
    
    // Approach 3: Array reversal
    public static boolean isPalindromeArrayReversal(String text) {
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];
        
        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }
        
        return new String(original).equals(new String(reversed));
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a word or phrase: ");
        String text = sc.nextLine().trim().toLowerCase();
        
        boolean iterative = isPalindromeIterative(text);
        boolean recursive = isPalindromeRecursive(text);
        boolean arrayReversal = isPalindromeArrayReversal(text);
        
        System.out.println("\n=== Palindrome Verification Results ===");
        System.out.println("Iterative: " + (iterative ? "Palindrome" : "Not Palindrome"));
        System.out.println("Recursive: " + (recursive ? "Palindrome" : "Not Palindrome"));
        System.out.println("Array Reversal: " + (arrayReversal ? "Palindrome" : "Not Palindrome"));
        
        if (iterative == recursive && recursive == arrayReversal) {
            System.out.println("\n✓ All three approaches agree!");
        } else {
            System.out.println("\n✗ Warning: Approaches disagree!");
        }
        
        sc.close();
    }
}
