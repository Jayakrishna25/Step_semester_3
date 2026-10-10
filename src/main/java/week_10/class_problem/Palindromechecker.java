package main.java.week_10.class_problem;
import java.util.Scanner;

class WordReverserPalindromeChecker {

    public static void checkWord(String word) {
        StringBuilder sb = new StringBuilder(word);
        String reversed = sb.reverse().toString();

        boolean isPalindrome = word.equalsIgnoreCase(reversed);

        if (isPalindrome) {
            System.out.println(reversed + " - palindrome");
        } else {
            System.out.println(reversed + " - not a palindrome");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String word = scanner.next();
            checkWord(word);
        }

        scanner.close();
    }
}
