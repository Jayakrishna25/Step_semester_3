package main.java.week_10.class_problem;
import java.util.Scanner;

class DigitSumAndReversal {

    public static void processNumber(int n) {
        int sumOfDigits = 0;
        int reversed = 0;
        int temp = n;

        while (temp > 0) {
            int digit = temp % 10;
            sumOfDigits += digit;
            reversed = reversed * 10 + digit;
            temp /= 10;
        }

        System.out.println("Sum of digits: " + sumOfDigits);
        System.out.println("Reverse: " + reversed);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        processNumber(n);

        scanner.close();
    }
}
