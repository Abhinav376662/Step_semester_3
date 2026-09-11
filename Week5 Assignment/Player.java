import java.util.Arrays;

public class Player implements Comparable<Player> {

    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public Player(
            String name,
            int matchesPlayed,
            double battingAverage,
            boolean injured) {

        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    // Experience-only rule
    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    // Combined matches-and-fitness rule
    static boolean isDraftable(
            int matchesPlayed,
            boolean injured) {

        return matchesPlayed >= 5 && !injured;
    }

    /*
     * Sort players by batting average in descending order.
     */
    @Override
    public int compareTo(Player other) {
        return Double.compare(
                other.battingAverage,
                this.battingAverage
        );
    }

    static String draftAndRank(Player[] players) {
        Player[] draftablePlayers =
                new Player[players.length];

        int count = 0;

        for (Player player : players) {
            boolean qualifiesByExperience =
                    isDraftable(player.matchesPlayed);

            boolean qualifiesByCombinedRule =
                    isDraftable(
                            player.matchesPlayed,
                            player.injured
                    );

            if (qualifiesByExperience
                    || qualifiesByCombinedRule) {

                draftablePlayers[count] = player;
                count++;
            }
        }

        Player[] finalList =
                Arrays.copyOf(draftablePlayers, count);

        Arrays.sort(finalList);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < finalList.length; i++) {
            result.append(i + 1)
                  .append(". ")
                  .append(finalList[i].name);

            if (i < finalList.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
    }
}
