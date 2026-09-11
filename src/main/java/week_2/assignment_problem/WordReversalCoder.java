package main.java.week_2.assignment_problem;
import java.util.Scanner;

class WordReversalEncoder {

    public static String reverseEachWord(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return sentence;
        }

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            StringBuilder reversedWord = new StringBuilder();
            String currentWord = words[i];

            for (int j = currentWord.length() - 1; j >= 0; j--) {
                reversedWord.append(currentWord.charAt(j));
            }

            result.append(reversedWord);

            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        String encoded = reverseEachWord(sentence);
        System.out.println(encoded);

        scanner.close();
    }
}
