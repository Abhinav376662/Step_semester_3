import java.util.Arrays;

public class HeightLineUp {

    public static void lineUp(int[] heights) {
        int n = heights.length;

        for (int pass = 1; pass < n; pass++) {
            boolean swapped = false;

            for (int j = 0; j < n - pass; j++) {
                if (heights[j] > heights[j + 1]) {
                    int temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;

                    swapped = true;
                }
            }

            System.out.println("Pass " + pass + ": " + Arrays.toString(heights));

            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        // Sample input 1
        int[] heights1 = {4, 2, 5, 1};
        System.out.println("Sample Input 1:");
        lineUp(heights1);

        System.out.println();

        // Sample input 2
        int[] heights2 = {1, 3, 2, 4};
        System.out.println("Sample Input 2:");
        lineUp(heights2);

        System.out.println();

        // Custom input
        int[] heights3 = {9, 3, 7, 1, 5};
        System.out.println("Custom Input:");
        lineUp(heights3);
    }
}
