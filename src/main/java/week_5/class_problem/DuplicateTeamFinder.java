package main.java.week_5.class_problem;
import java.util.Scanner;

class DuplicateTeamFinder {

    static String findDuplicateTeam(String[] teamNames) {
        if (teamNames == null || teamNames.length <= 1) {
            return "No Duplicates Found";
        }

        for (int i = 0; i < teamNames.length; i++) {
            for (int j = i + 1; j < teamNames.length; j++) {
                if (teamNames[i].equals(teamNames[j])) {
                    return "Duplicate Found: " + teamNames[i];
                }
            }
        }

        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of teams: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        String[] teamNames = new String[n];
        System.out.println("Enter team names:");
        for (int i = 0; i < n; i++) {
            teamNames[i] = scanner.nextLine().trim();
        }

        String result = findDuplicateTeam(teamNames);
        System.out.println(result);

        scanner.close();
    }
}
