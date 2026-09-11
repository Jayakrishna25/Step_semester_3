package main.java.week_1.assignment_problem;
import java.util.Scanner;

class SeatDuplicationChecker {

    public static void checkDuplicateSeats(int[] seatNumbers) {
        if (seatNumbers == null || seatNumbers.length <= 1) {
            System.out.println("No Duplicate Seats Found");
            return;
        }

        int n = seatNumbers.length;
        int[] printedDuplicates = new int[n];
        int printedCount = 0;
        boolean duplicateFound = false;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    boolean alreadyReported = false;
                    for (int k = 0; k < printedCount; k++) {
                        if (printedDuplicates[k] == seatNumbers[i]) {
                            alreadyReported = true;
                            break;
                        }
                    }

                    if (!alreadyReported) {
                        System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                        printedDuplicates[printedCount] = seatNumbers[i];
                        printedCount++;
                        duplicateFound = true;
                    }
                    break;
                }
            }
        }

        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of assigned seats: ");
        int count = scanner.nextInt();

        int[] seatNumbers = new int[count];
        System.out.println("Enter the seat numbers:");
        for (int i = 0; i < count; i++) {
            seatNumbers[i] = scanner.nextInt();
        }

        checkDuplicateSeats(seatNumbers);

        scanner.close();
    }
}
