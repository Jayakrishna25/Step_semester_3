package main.java.week_2.class_problem;
import java.util.Scanner;

class VowelConsonantCounter {

    public static void countVowelsAndConsonants(String text) {
        if (text == null) {
            System.out.println("Vowels: 0 | Consonants: 0");
            return;
        }

        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = Character.toLowerCase(text.charAt(i));

            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.printf("Vowels: %d | Consonants: %d\n", vowels, consonants);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a book title: ");
        String title = scanner.nextLine();

        countVowelsAndConsonants(title);

        scanner.close();
    }
}
