package main.java.week_10.class_problem;
import java.util.Scanner;

class EvenOddCounter {

    public static void countEvenOdd(int[] numbers) {
        int evenCount = 0;
        int oddCount = 0;

        for (int num : numbers) {
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        System.out.println("Even: " + evenCount);
        System.out.println("Odd: " + oddCount);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextLine()) {
            scanner.close();
            return;
        }

        String line = scanner.nextLine().trim();

        // Strip enclosing square brackets if input is provided as [3, 8, 12, 5, 7, 10]
        if (line.startsWith("[") && line.endsWith("]")) {
            line = line.substring(1, line.length() - 1).trim();
        }

        if (line.isEmpty()) {
            System.out.println("Even: 0");
            System.out.println("Odd: 0");
            scanner.close();
            return;
        }

        // Split by commas and/or whitespace
        String[] parts = line.split("[,\\s]+");
        int[] numbers = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            numbers[i] = Integer.parseInt(parts[i]);
        }

        countEvenOdd(numbers);

        scanner.close();
    }
}
