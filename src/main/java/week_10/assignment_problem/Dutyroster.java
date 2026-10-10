package main.java.week_10.assignment_problem;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class DutyRosterRotation {

    public static void rotateRosterInPlace(String[] names, long k) {
        int n = names.length;
        if (n <= 1) {
            return;
        }

        // Normalize k to handle both large values and negative rotations
        int effectiveK = (int) (k % n);
        if (effectiveK < 0) {
            effectiveK += n;
        }

        if (effectiveK == 0) {
            return;
        }

        // 1. Reverse the entire array: [A, B, C, D, E] -> [E, D, C, B, A]
        reverse(names, 0, n - 1);
        // 2. Reverse the first k elements: [E, D] -> [D, E]
        reverse(names, 0, effectiveK - 1);
        // 3. Reverse the remaining n - k elements: [C, B, A] -> [A, B, C]
        reverse(names, effectiveK, n - 1);
    }

    private static void reverse(String[] arr, int left, int right) {
        while (left < right) {
            String temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextLine()) {
            scanner.close();
            return;
        }

        String line = scanner.nextLine().trim();
        scanner.close();

        // 1. Extract bracketed array content: [ ... ]
        int openBracket = line.indexOf('[');
        int closeBracket = line.indexOf(']');

        if (openBracket == -1 || closeBracket == -1 || closeBracket < openBracket) {
            System.out.println("[]");
            return;
        }

        String rosterContent = line.substring(openBracket + 1, closeBracket).trim();
        if (rosterContent.isEmpty()) {
            System.out.println("[]");
            return;
        }

        String[] names = rosterContent.split("[,\\s]+");

        // 2. Extract k from the remainder of the line after ']' (e.g., ", k = 2")
        long k = 0;
        String afterBrackets = line.substring(closeBracket + 1);
        Matcher matcher = Pattern.compile("-?\\d+").matcher(afterBrackets);

        if (matcher.find()) {
            k = Long.parseLong(matcher.group());
        }

        // 3. Rotate and print result
        rotateRosterInPlace(names, k);
        System.out.println(Arrays.toString(names));
    }
}