import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }
        
        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }
        
        return "Computer Wins";
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        String[] moves = {"Rock", "Paper", "Scissors"};
        
        int n = 5; // Number of rounds
        int wins = 0, losses = 0, draws = 0;
        
        String[][] scoreboard = new String[n][4];
        
        System.out.println("=== Rock-Paper-Scissors Arcade ===\n");
        
        for (int i = 0; i < n; i++) {
            System.out.print("Round " + (i + 1) + " - Enter your move (Rock/Paper/Scissors): ");
            String playerMove = sc.nextLine().trim();
            
            // Validate input
            while (!playerMove.equalsIgnoreCase("Rock") && 
                   !playerMove.equalsIgnoreCase("Paper") && 
                   !playerMove.equalsIgnoreCase("Scissors")) {
                System.out.print("Invalid move! Enter Rock, Paper, or Scissors: ");
                playerMove = sc.nextLine().trim();
            }
            
            playerMove = playerMove.substring(0, 1).toUpperCase() + playerMove.substring(1).toLowerCase();
            String computerMove = moves[rand.nextInt(3)];
            
            String result = playRound(playerMove, computerMove);
            
            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;
            
            scoreboard[i][0] = String.valueOf(i + 1);
            scoreboard[i][1] = playerMove;
            scoreboard[i][2] = computerMove;
            scoreboard[i][3] = result;
            
            System.out.println("Round " + (i + 1) + " — Player: " + playerMove + 
                             ", Computer: " + computerMove + " → " + result + "\n");
        }
        
        // Print summary table
        System.out.println("\n=== Final Summary ===");
        System.out.printf("%-8s | %-10s | %-12s | %-15s%n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("---------|------------|--------------|----------------");
        
        for (int i = 0; i < n; i++) {
            System.out.printf("%-8s | %-10s | %-12s | %-15s%n", 
                            scoreboard[i][0], scoreboard[i][1], 
                            scoreboard[i][2], scoreboard[i][3]);
        }
        
        double winPercentage = (wins * 100.0) / n;
        System.out.printf("\nWins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n", 
                         wins, losses, draws, winPercentage);
        
        sc.close();
    }
}
