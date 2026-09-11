import java.util.Scanner;

public class Problem2 {

    // Approach 1: Iterative comparison
    static boolean isPalindromeIterative(String text) {
        int left = 0;
        int right = text.length() - 1;

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
    static boolean isPalindromeRecursive(String text) {
        return checkRecursive(text, 0, text.length() - 1);
    }

    private static boolean checkRecursive(
            String text,
            int left,
            int right) {

        if (left >= right) {
            return true;
        }

        if (text.charAt(left) != text.charAt(right)) {
            return false;
        }

        return checkRecursive(text, left + 1, right - 1);
    }

    // Approach 3: Character-array reversal
    static boolean isPalindromeArrayReversal(String text) {
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];

        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }

        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }

        return true;
    }

    static String getResult(boolean palindrome) {
        if (palindrome) {
            return "Palindrome";
        }

        return "Not Palindrome";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        boolean iterativeResult =
                isPalindromeIterative(text);

        boolean recursiveResult =
                isPalindromeRecursive(text);

        boolean arrayResult =
                isPalindromeArrayReversal(text);

        System.out.println(
                "Iterative: "
                        + getResult(iterativeResult)
        );

        System.out.println(
                "Recursive: "
                        + getResult(recursiveResult)
        );

        System.out.println(
                "Array Reversal: "
                        + getResult(arrayResult)
        );

        boolean allMethodsAgree =
                iterativeResult
                        == recursiveResult
                        && recursiveResult == arrayResult;

        System.out.println(
                "All methods agree: " + allMethodsAgree
        );

        scanner.close();
    }
}
