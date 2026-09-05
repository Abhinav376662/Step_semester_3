import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class WordFrequencyAnalyzer {
    
    public static void printFilteredWordFrequency(String feedback) {
        System.out.println("\n=== Stop-Word-Filtered Word Frequency Report ===\n");
        
        // Define stop words
        String[] stopWordsArray = {"the", "was", "and", "a", "is", "of", "in"};
        HashMap<String, Boolean> stopWords = new HashMap<>();
        for (String word : stopWordsArray) {
            stopWords.put(word, true);
        }
        
        // Normalize: lowercase and remove punctuation
        String cleaned = feedback.toLowerCase();
        cleaned = cleaned.replace(".", "");
        cleaned = cleaned.replace(",", "");
        cleaned = cleaned.replace("!", "");
        cleaned = cleaned.replace("?", "");
        
        // Split into words
        String[] words = cleaned.trim().split("\\s+");
        
        // Count frequency (excluding stop words)
        HashMap<String, Integer> frequency = new HashMap<>();
        
        for (String word : words) {
            if (!stopWords.containsKey(word) && !word.isEmpty()) {
                frequency.put(word, frequency.getOrDefault(word, 0) + 1);
            }
        }
        
        // Sort by frequency (descending)
        ArrayList<String> sortedWords = new ArrayList<>(frequency.keySet());
        sortedWords.sort((w1, w2) -> frequency.get(w2) - frequency.get(w1));
        
        // Print results
        if (sortedWords.isEmpty()) {
            System.out.println("No meaningful words found!");
        } else {
            for (String word : sortedWords) {
                System.out.println(word + ": " + frequency.get(word));
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter feedback paragraph: ");
        String feedback = sc.nextLine();
        
        printFilteredWordFrequency(feedback);
        
        sc.close();
    }
}
