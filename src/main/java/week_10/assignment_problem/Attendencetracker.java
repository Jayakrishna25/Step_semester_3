package main.java.week_10.assignment_problem;
import java.util.Scanner;

class ClassAttendanceTracker {

    public static class AttendanceResult {
        public final int presentDays;
        public final int longestStreak;

        public AttendanceResult(int presentDays, int longestStreak) {
            this.presentDays = presentDays;
            this.longestStreak = longestStreak;
        }

        @Override
        public String toString() {
            return String.format("Present: %d, Longest streak: %d", presentDays, longestStreak);
        }
    }

    /**
     * Computes the total present days and the maximum contiguous sequence of present days
     * in a single pass.
     */
    public static AttendanceResult attendanceSummary(int[] days) {
        int totalPresent = 0;
        int currentStreak = 0;
        int maxStreak = 0;

        for (int day : days) {
            if (day == 1) {
                totalPresent++;
                currentStreak++;
                if (currentStreak > maxStreak) {
                    maxStreak = currentStreak;
                }
            } else {
                currentStreak = 0;
            }
        }

        return new AttendanceResult(totalPresent, maxStreak);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextLine()) {
            scanner.close();
            return;
        }

        String line = scanner.nextLine().trim();

        // Handle bracketed input e.g., [1, 1, 0, 1, 1, 1, 0, 1]
        if (line.startsWith("[") && line.endsWith("]")) {
            line = line.substring(1, line.length() - 1).trim();
        }

        if (line.isEmpty()) {
            System.out.println("Present: 0, Longest streak: 0");
            scanner.close();
            return;
        }

        String[] tokens = line.split("[,\\s]+");
        int[] days = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            days[i] = Integer.parseInt(tokens[i]);
        }

        AttendanceResult result = attendanceSummary(days);
        System.out.println(result);

        scanner.close();
    }
}