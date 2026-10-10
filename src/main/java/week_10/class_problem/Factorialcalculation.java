package main.java.week_10.class_problem;
import java.util.Scanner;

class FactorialCalculation {

    public static long calculateFactorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            System.out.println(calculateFactorial(n));
        }

        scanner.close();
    }
}