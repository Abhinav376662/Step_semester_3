import java.util.Random;
import java.util.Scanner;

public class Problem1 {

    static String playRound(
            String playerMove,
            String computerMove) {

        playerMove = playerMove.toLowerCase();
        computerMove = computerMove.toLowerCase();

        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("rock")
                && computerMove.equals("scissors"))
                || (playerMove.equals("paper")
                && computerMove.equals("rock"))
                || (playerMove.equals("scissors")
                && computerMove.equals("paper"))) {

            return "Player Wins";
        }

        return "Computer Wins";
    }

    static String getRandomMove(Random random) {
        String[] moves = {"Rock", "Paper", "Scissors"};

        int randomIndex = random.nextInt(moves.length);

        return moves[randomIndex];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numberOfRounds = 5;

        String[] playerMoves = new String[numberOfRounds];
        String[] computerMoves = new String[numberOfRounds];
        String[] results = new String[numberOfRounds];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.println("Rock-Paper-Scissors Game");
        System.out.println("Enter Rock, Paper, or Scissors.");

        for (int i = 0; i < numberOfRounds; i++) {
            System.out.print("Round " + (i + 1)
                    + " - Enter your move: ");

            String playerMove = scanner.nextLine();

            while (!playerMove.equalsIgnoreCase("rock")
                    && !playerMove.equalsIgnoreCase("paper")
                    && !playerMove.equalsIgnoreCase("scissors")) {

                System.out.print(
                        "Invalid move. Enter Rock, Paper, or Scissors: "
                );

                playerMove = scanner.nextLine();
            }

            String computerMove = getRandomMove(random);

            String result = playRound(
                    playerMove,
                    computerMove
            );

            playerMoves[i] = formatMove(playerMove);
            computerMoves[i] = computerMove;
            results[i] = result;

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            System.out.println(
                    "Computer Move: " + computerMove
            );

            System.out.println("Result: " + result);
            System.out.println();
        }

        double winPercentage =
                (double) wins / numberOfRounds * 100;

        System.out.println("Final Summary");
        System.out.println("-----------------------------------------------");
        System.out.printf(
                "%-8s %-15s %-17s %-15s%n",
                "Round",
                "Player Move",
                "Computer Move",
                "Result"
        );
        System.out.println("-----------------------------------------------");

        for (int i = 0; i < numberOfRounds; i++) {
            System.out.printf(
                    "%-8d %-15s %-17s %-15s%n",
                    i + 1,
                    playerMoves[i],
                    computerMoves[i],
                    results[i]
            );
        }

        System.out.println("-----------------------------------------------");
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.printf(
                "Win Percentage: %.1f%%%n",
                winPercentage
        );

        scanner.close();
    }

    static String formatMove(String move) {
        move = move.toLowerCase();

        return move.substring(0, 1).toUpperCase()
                + move.substring(1);
    }
}
