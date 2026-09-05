import java.util.Scanner;

public class MovieReviewWordProfiler {
    
    public static void classifyWordLengths(String review) {
        System.out.println("\n=== Movie Review Word Length Profiler ===\n");
        
        // Split review into words (split by whitespace)
        String[] words = review.trim().split("\\s+");
        
        int shortCount = 0;   // 1-4 letters
        int mediumCount = 0;  // 5-8 letters
        int longCount = 0;    // 9+ letters
        
        // Classify each word
        for (String word : words) {
            // Remove punctuation for accurate counting
            word = word.replaceAll("[^a-zA-Z]", "");
            
            if (word.isEmpty()) {
                continue;
            }
            
            int length = word.length();
            
            if (length >= 1 && length <= 4) {
                shortCount++;
            } else if (length >= 5 && length <= 8) {
                mediumCount++;
            } else if (length >= 9) {
                longCount++;
            }
        }
        
        System.out.printf("Short (1-4): %d | Medium (5-8): %d | Long (9+): %d%n", 
                         shortCount, mediumCount, longCount);
        
        int total = shortCount + mediumCount + longCount;
        System.out.printf("Total Words Analyzed: %d%n", total);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter movie review: ");
        String review = sc.nextLine();
        
        classifyWordLengths(review);
        
        sc.close();
    }
}
