package main.java.week_1.assignment_problem;
import java.util.Scanner;

class TypingSpeedAccuracyChecker {

    public static void checkTypingAccuracy(String original, String typed) {
        if (original == null || typed == null) {
            System.out.println("Invalid input strings.");
            return;
        }

        if (original.length() != typed.length()) {
            System.out.println("Error: The original and typed texts must be of equal length.");
            return;
        }

        int totalLength = original.length();
        if (totalLength == 0) {
            System.out.println("Matched: 0/0 | Accuracy: 100.00% | No Mismatches");
            return;
        }

        int matchedCount = 0;
        int firstMismatchPos = -1;
        char originalCharMismatch = '\0';
        char typedCharMismatch = '\0';

        for (int i = 0; i < totalLength; i++) {
            char origChar = original.charAt(i);
            char typedChar = typed.charAt(i);

            if (origChar == typedChar) {
                matchedCount++;
            } else if (firstMismatchPos == -1) {
                firstMismatchPos = i + 1;
                originalCharMismatch = origChar;
                typedCharMismatch = typedChar;
            }
        }

        double accuracy = ((double) matchedCount / totalLength) * 100.0;

        System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | ", matchedCount, totalLength, accuracy);

        if (firstMismatchPos != -1) {
            System.out.printf("First Mismatch at position %d ('%c' vs '%c')\n",
                    firstMismatchPos, originalCharMismatch, typedCharMismatch);
        } else {
            System.out.println("No Mismatches");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the original text: ");
        String original = scanner.nextLine();

        System.out.print("Enter the typed text:    ");
        String typed = scanner.nextLine();

        checkTypingAccuracy(original, typed);

        scanner.close();
    }
}
