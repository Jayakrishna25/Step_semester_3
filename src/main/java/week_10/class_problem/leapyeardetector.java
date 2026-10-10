package main.java.week_10.class_problem;
import java.util.Scanner;

class LeapYearDetector {

    public static boolean isLeapYear(int year) {
        // Divisible by 400 OR (divisible by 4 AND not divisible by 100)
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            int year = scanner.nextInt();
            if (isLeapYear(year)) {
                System.out.println("Leap year");
            } else {
                System.out.println("Not a leap year");
            }
        }

        scanner.close();
    }
}