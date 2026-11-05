import java.util.Arrays;

public class DiceThrowTally {

    public static int[] diceSort(int[] rolls) {
        int[] count = new int[7];

        for (int roll : rolls) {
            count[roll]++;
        }

        System.out.print("Counts: ");
        for (int value = 1; value <= 6; value++) {
            System.out.print(value + ":" + count[value] + " ");
        }
        System.out.println();

        int[] sortedRolls = new int[rolls.length];
        int index = 0;

        for (int value = 1; value <= 6; value++) {
            for (int repetition = 0; repetition < count[value]; repetition++) {
                sortedRolls[index] = value;
                index++;
            }
        }

        return sortedRolls;
    }

    public static void main(String[] args) {
        int[] rolls1 = {4, 1, 6, 4, 2, 1, 4};
        int[] sorted1 = diceSort(rolls1);

        System.out.println("Sorted: " + Arrays.toString(sorted1));

        System.out.println();

        int[] rolls2 = {6, 6, 3, 3, 3, 1, 5, 2};
        int[] sorted2 = diceSort(rolls2);

        System.out.println("Sorted: " + Arrays.toString(sorted2));
    }
}
