import java.util.Scanner;

public class Problem1 {

    static void countVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);

            if (current == ' ') {
                continue;
            }

            char lowerCaseCharacter =
                    Character.toLowerCase(current);

            if (lowerCaseCharacter == 'a'
                    || lowerCaseCharacter == 'e'
                    || lowerCaseCharacter == 'i'
                    || lowerCaseCharacter == 'o'
                    || lowerCaseCharacter == 'u') {

                vowels++;
            } else {
                consonants++;
            }
        }

        System.out.println(
                "Vowels: " + vowels
                        + " | Consonants: " + consonants
        );
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a book title: ");
        String text = scanner.nextLine();

        countVowelsAndConsonants(text);

        scanner.close();
    }
}
