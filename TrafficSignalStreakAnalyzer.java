import java.util.Scanner;

public class TrafficSignalStreakAnalyzer {
    
    public static void findLongestStreak(String signalLog) {
        System.out.println("\n=== Traffic Signal Streak Analyzer ===\n");
        
        if (signalLog.isEmpty()) {
            System.out.println("No signal data provided!");
            return;
        }
        
        char longestColor = signalLog.charAt(0);
        int longestStreak = 1;
        
        char currentColor = signalLog.charAt(0);
        int currentStreak = 1;
        
        // Scan through the string
        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == currentColor) {
                currentStreak++;
            } else {
                // Check if current streak is the longest
                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                    longestColor = currentColor;
                }
                // Reset for new color
                currentColor = signalLog.charAt(i);
                currentStreak = 1;
            }
        }
        
        // Final check after loop ends
        if (currentStreak > longestStreak) {
            longestStreak = currentStreak;
            longestColor = currentColor;
        }
        
        System.out.printf("Longest Streak: '%c' repeated %d times%n", 
                         longestColor, longestStreak);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter signal log (e.g., RRGGGYRR): ");
        String signalLog = sc.nextLine().trim().toUpperCase();
        
        findLongestStreak(signalLog);
        
        sc.close();
    }
}
