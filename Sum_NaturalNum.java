import java.util.Scanner;

public class Sum_NaturalNum {

    static void sumOfNaturalNumbers(int n) {
        int i = 1;
        int sum = 0;
        while (i != n + 1) {
            sum = sum + i;
            i++;
        }
        System.out.println("Sum of numbers from 1 to " + n + " = " + sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sum_NaturalNum s = new Sum_NaturalNum();

        System.out.print("Enter a number : ");
        int num = sc.nextInt();

        sumOfNaturalNumbers(num);

    }
}
