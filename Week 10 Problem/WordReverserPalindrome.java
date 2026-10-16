import java.util.Scanner;

public class WordReverserPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();

        StringBuilder sb = new StringBuilder(word);
        String reversed = sb.reverse().toString();

        System.out.println(reversed + (word.equals(reversed)
                ? " - palindrome"
                : " - not a palindrome"));

        sc.close();
    }
}
