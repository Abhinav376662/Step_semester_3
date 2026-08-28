import java.util.Scanner;

public class print_Number {
    static void printNumbersUpToN(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        print_Number n = new print_Number();

        System.out.println("Enter a number: ");
        int num = sc.nextInt();

        n.printNumbersUpToN(num);
    }
}
