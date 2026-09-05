import java.util.Scanner;

public class WordReversalEncoder {
    
    public static String reverseEachWord(String sentence) {
        System.out.println("\n=== Word Reversal Encoder ===\n");
        
        // Split sentence into words
        String[] words = sentence.split(" ");
        
        StringBuilder result = new StringBuilder();
        
        // Reverse each word
        for (int i = 0; i < words.length; i++) {
            StringBuilder reversed = new StringBuilder(words[i]);
            reversed.reverse();
            
            result.append(reversed);
            
            // Add space between words (but not after last word)
            if (i < words.length - 1) {
                result.append(" ");
            }
        }
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();
        
        String encoded = reverseEachWord(sentence);
        System.out.println("Encoded: " + encoded);
        
        sc.close();
    }
}
