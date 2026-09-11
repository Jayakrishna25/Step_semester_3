package main.java.week_1.class_problem;
import java.util.Random;
import java.util.Scanner;

class RockPaperScissorsArcade {

    private static final String[] VALID_MOVES = {"Rock", "Paper", "Scissors"};
    private static final Random RANDOM = new Random();

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        switch (playerMove.toLowerCase()) {
            case "rock":
                return computerMove.equalsIgnoreCase("Scissors") ? "Player Wins" : "Computer Wins";
            case "paper":
                return computerMove.equalsIgnoreCase("Rock") ? "Player Wins" : "Computer Wins";
            case "scissors":
                return computerMove.equalsIgnoreCase("Paper") ? "Player Wins" : "Computer Wins";
            default:
                return "Invalid";
        }
    }

    private static String getComputerMove() {
        return VALID_MOVES[RANDOM.nextInt(VALID_MOVES.length)];
    }

    private static String formatMove(String move) {
        for (String validMove : VALID_MOVES) {
            if (validMove.equalsIgnoreCase(move)) {
                return validMove;
            }
        }
        return move;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int totalRounds = 5;

        int[] roundNumbers = new int[totalRounds];
        String[] playerMoves = new String[totalRounds];
        String[] computerMoves = new String[totalRounds];
        String[] roundResults = new String[totalRounds];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.println("==============================================");
        System.out.println("  Welcome to the College Coding Arcade: RPS!  ");
        System.out.println("==============================================");

        for (int i = 0; i < totalRounds; i++) {
            int currentRound = i + 1;
            String playerMove = "";

            while (true) {
                System.out.print("\nRound " + currentRound + " - Enter move (Rock, Paper, Scissors): ");
                playerMove = scanner.nextLine().trim();

                if (playerMove.equalsIgnoreCase("Rock") ||
                        playerMove.equalsIgnoreCase("Paper") ||
                        playerMove.equalsIgnoreCase("Scissors")) {
                    break;
                }
                System.out.println("Invalid input! Please choose Rock, Paper, or Scissors.");
            }

            playerMove = formatMove(playerMove);
            String compMove = getComputerMove();
            String result = playRound(playerMove, compMove);

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            roundNumbers[i] = currentRound;
            playerMoves[i] = playerMove;
            computerMoves[i] = compMove;
            roundResults[i] = result;

            System.out.printf("Round %d — Player: %s, Computer: %s -> %s\n",
                    currentRound, playerMove, compMove, result);
        }

        System.out.println("\n" + "=".repeat(50));
        System.out.println("                MATCH SUMMARY TABLE               ");
        System.out.println("=".repeat(50));
        System.out.printf("%-8s | %-12s | %-14s | %-14s\n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("-".repeat(50));

        for (int i = 0; i < totalRounds; i++) {
            System.out.printf("%-8d | %-12s | %-14s | %-14s\n",
                    roundNumbers[i], playerMoves[i], computerMoves[i], roundResults[i]);
        }

        double winPercentage = ((double) wins / totalRounds) * 100.0;

        System.out.println("=".repeat(50));
        System.out.printf("Final Summary (after %d rounds): Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%\n",
                totalRounds, wins, losses, draws, winPercentage);
        System.out.println("=".repeat(50));

        scanner.close();
    }
}
