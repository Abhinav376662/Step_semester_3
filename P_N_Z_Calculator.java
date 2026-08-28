import java.util.Scanner;

public class P_N_Z_Calculator {

    static void classifyNumber(int number) {
        if (number > 0) {
            System.out.println("Positive");
        } else if (number < 0) {
            System.out.println("Negative");
        } else {
            System.out.println("Zero");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        P_N_Z_Calculator c = new P_N_Z_Calculator();

        System.out.println("Enter a number: ");
        int n = sc.nextInt();

        c.classifyNumber(n);
    }
}
