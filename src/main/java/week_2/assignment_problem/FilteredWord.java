package main.java.week_2.assignment_problem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class FilteredWordFrequencyReport {

    public static void printFilteredWordFrequency(String feedback) {
        if (feedback == null || feedback.trim().isEmpty()) {
            return;
        }

        Set<String> stopWords = new HashSet<>(Arrays.asList("the", "was", "and", "a", "is", "of", "in"));

        String cleanedText = feedback.toLowerCase()
                .replace(".", "")
                .replace(",", "")
                .replace("!", "")
                .replace("?", "")
                .replace(";", "")
                .replace(":", "");

        String[] words = cleanedText.trim().split("\\s+");

        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String word : words) {
            if (word.isEmpty() || stopWords.contains(word)) {
                continue;
            }
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());

        entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        for (Map.Entry<String, Integer> entry : entryList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter feedback paragraph:");
        String feedback = scanner.nextLine();

        printFilteredWordFrequency(feedback);

        scanner.close();
    }
}