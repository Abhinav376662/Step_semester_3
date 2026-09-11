import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem4 {

    static char findFirstNonRepeatingChar(String text) {
        Map<Character, Integer> frequencyMap =
                new HashMap<>();

        // Count the frequency of every character
        for (int i = 0; i < text.length(); i++) {
            char currentCharacter = text.charAt(i);

            frequencyMap.put(
                    currentCharacter,
                    frequencyMap.getOrDefault(
                            currentCharacter,
                            0
                    ) + 1
            );
        }

        // Find the first character with frequency one
        for (int i = 0; i < text.length(); i++) {
            char currentCharacter = text.charAt(i);

            if (frequencyMap.get(currentCharacter) == 1) {
                return currentCharacter;
            }
        }

        return '\0';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word or sentence: ");
        String text = scanner.nextLine();

        char result = findFirstNonRepeatingChar(text);

        if (result == '\0') {
            System.out.println(
                    "No Non-Repeating Character Found"
            );
        } else {
            System.out.println(
                    "First Non-Repeating Character: '"
                            + result
                            + "'"
            );
        }

        scanner.close();
    }
}
