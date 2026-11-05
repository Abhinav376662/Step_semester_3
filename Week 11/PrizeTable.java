import java.util.Arrays;

public class PrizeTable {

    public static int prizeTable(int[] marks) {
        int n = marks.length;
        int swapCount = 0;

        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (marks[j] > marks[maxIndex]) {
                    maxIndex = j;
                }
            }

            if (maxIndex != i) {
                int temp = marks[i];
                marks[i] = marks[maxIndex];
                marks[maxIndex] = temp;

                swapCount++;
            }
        }

        return swapCount;
    }

    public static void main(String[] args) {
        // Sample input 1
        int[] marks1 = {45, 90, 60, 75};
        int swaps1 = prizeTable(marks1);

        System.out.println(Arrays.toString(marks1) + " swaps = " + swaps1);

        // Sample input 2
        int[] marks2 = {80, 70, 60};
        int swaps2 = prizeTable(marks2);

        System.out.println(Arrays.toString(marks2) + " swaps = " + swaps2);

        // Custom input
        int[] marks3 = {55, 20, 95, 40, 70};
        int swaps3 = prizeTable(marks3);

        System.out.println(Arrays.toString(marks3) + " swaps = " + swaps3);
    }
}
