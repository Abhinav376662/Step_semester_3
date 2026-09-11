import java.util.Arrays;

public class HackathonProblems {

    // Problem 1: Hackathon Score Curve Booster
    static void curveScores(int[] scores, int bonus) {
        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
    }

    // Problem 2: Duplicate Team Name Finder
    static String findDuplicateTeam(String[] teamNames) {
        for (int i = 0; i < teamNames.length; i++) {
            for (int j = i + 1; j < teamNames.length; j++) {
                if (teamNames[i].equals(teamNames[j])) {
                    return "Duplicate Found: " + teamNames[i];
                }
            }
        }

        return "No Duplicates Found";
    }

    // Problem 3: Top-3 Podium Finder
    static int[] findTopThreeScores(int[] scores) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int score : scores) {
            if (score >= first) {
                third = second;
                second = first;
                first = score;
            } else if (score >= second) {
                third = second;
                second = score;
            } else if (score > third) {
                third = score;
            }
        }

        return new int[]{first, second, third};
    }

    // Problem 4: Helper method for calculating one row's average
    private static double rowAverage(int[] row) {
        int sum = 0;

        for (int score : row) {
            sum += score;
        }

        return (double) sum / row.length;
    }

    // Problem 4: Seating grid classification
    static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < seatingScores.length; i++) {
            double average = rowAverage(seatingScores[i]);

            if (average < threshold) {
                result.append("Row ").append(i).append(": Quiet Zone");
            } else {
                result.append("Row ").append(i).append(": Buzzing Zone");
            }

            if (i < seatingScores.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        // Problem 1
        int[] scores = {70, 85, 60};
        curveScores(scores, 10);
        System.out.println(Arrays.toString(scores));
        // Output: [80, 95, 70]


        // Problem 2
        String[] teamNames = {
            "ByteForce",
            "CodeCrafters",
            "ByteForce"
        };

        System.out.println(findDuplicateTeam(teamNames));
        // Output: Duplicate Found: ByteForce


        // Problem 3
        int[] podiumScores = {45, 82, 79, 90, 33, 90, 61};

        int[] topThree = findTopThreeScores(podiumScores);
        System.out.println(Arrays.toString(topThree));
        // Output: [90, 90, 82]


        // Problem 4
        int[][] seatingScores = {
            {40, 50, 45},
            {85, 90, 95},
            {30, 20, 25}
        };

        System.out.println(classifyRows(seatingScores, 60));
        // Output:
        // Row 0: Quiet Zone | Row 1: Buzzing Zone | Row 2: Quiet Zone
    }
}
