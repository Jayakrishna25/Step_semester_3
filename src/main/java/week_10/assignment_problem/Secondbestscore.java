package main.java.week_10.assignment_problem;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {

    /**
     * Finds the second-highest distinct score in O(n) time and O(1) space.
     * Returns -1 if no second-highest distinct score exists.
     */
    public static int secondHighest(int[] scores) {
        if (scores == null || scores.length < 2) {
            return -1;
        }

        int highest = -1;
        int second = -1;

        for (int score : scores) {
            if (score > highest) {
                second = highest;
                highest = score;
            } else if (score < highest && score > second) {
                second = score;
            }
        }

        return second;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextLine()) {
            scanner.close();
            return;
        }

        String line = scanner.nextLine().trim();

        // Support formats like:
        // 1. scores = [45, 78, 92, 78, 60]
        // 2. [50, 50, 50]
        // 3. 45 78 92 78 60
        if (line.contains("[") && line.contains("]")) {
            int openIdx = line.indexOf('[');
            int closeIdx = line.indexOf(']');
            String arrayContent = line.substring(openIdx + 1, closeIdx).trim();

            if (arrayContent.isEmpty()) {
                System.out.println(-1);
                scanner.close();
                return;
            }

            String[] tokens = arrayContent.split("[,\\s]+");
            int[] scores = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                scores[i] = Integer.parseInt(tokens[i]);
            }

            System.out.println(secondHighest(scores));
        } else {
            // Fallback for standard whitespace-separated values
            String[] tokens = line.split("\\s+");
            int[] scores = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                scores[i] = Integer.parseInt(tokens[i]);
            }

            System.out.println(secondHighest(scores));
        }

        scanner.close();
    }
}