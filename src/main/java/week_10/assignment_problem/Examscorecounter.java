package main.java.week_10.assignment_problem;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ExamScoreBandCounter {

    public static int lowerBound(int[] scores, int target) {
        int left = 0;
        int right = scores.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static int upperBound(int[] scores, int target) {
        int left = 0;
        int right = scores.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static int countInBand(int[] scores, int low, int high) {
        if (scores == null || scores.length == 0 || low > high) {
            return 0;
        }

        int firstIndex = lowerBound(scores, low);
        int beyondIndex = upperBound(scores, high);

        return beyondIndex - firstIndex;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextLine()) {
            scanner.close();
            return;
        }

        String line = scanner.nextLine().trim();

        if (line.contains("[") && line.contains("]")) {
            int openIdx = line.indexOf('[');
            int closingIdx = line.indexOf(']');

            String arrayPart = line.substring(openIdx + 1, closingIdx).trim();
            String remainder = line.substring(closingIdx + 1);

            String[] scoreTokens = arrayPart.split("[,\\s]+");
            int[] scores = new int[scoreTokens.length];
            for (int i = 0; i < scoreTokens.length; i++) {
                scores[i] = Integer.parseInt(scoreTokens[i]);
            }

            // Extract low and high regardless of spacing around '='
            Matcher lowMatcher = Pattern.compile("low\\s*=\\s*(\\d+)").matcher(remainder);
            Matcher highMatcher = Pattern.compile("high\\s*=\\s*(\\d+)").matcher(remainder);

            int low = lowMatcher.find() ? Integer.parseInt(lowMatcher.group(1)) : 0;
            int high = highMatcher.find() ? Integer.parseInt(highMatcher.group(1)) : 0;

            System.out.println(countInBand(scores, low, high));
        }

        scanner.close();
    }
}