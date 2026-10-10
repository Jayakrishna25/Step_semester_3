package main.java.week_10.assignment_problem;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class BusiestBusRow {

    public static class RowResult {
        public final int rowIndex;
        public final int totalStudents;

        public RowResult(int rowIndex, int totalStudents) {
            this.rowIndex = rowIndex;
            this.totalStudents = totalStudents;
        }

        @Override
        public String toString() {
            return String.format("Row %d, Total %d", rowIndex, totalStudents);
        }
    }

    public static RowResult busiestRow(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return new RowResult(0, 0);
        }

        int bestRowIndex = 0;
        int maxTotal = Integer.MIN_VALUE;

        for (int r = 0; r < grid.length; r++) {
            int currentRowSum = 0;
            for (int c = 0; c < grid[r].length; c++) {
                currentRowSum += grid[r][c];
            }

            if (currentRowSum > maxTotal) {
                maxTotal = currentRowSum;
                bestRowIndex = r;
            }
        }

        return new RowResult(bestRowIndex, maxTotal);
    }

    /**
     * Extracts row blocks enclosed in brackets (e.g. "[2, 0, 1]")
     * and converts them into a 2D integer array.
     */
    public static int[][] parseBracketMatrix(String input) {
        List<int[]> rowList = new ArrayList<>();

        // Matches inner bracketed row sequences: [ ... ]
        Pattern rowPattern = Pattern.compile("\\[([^\\[\\]]+)\\]");
        Matcher rowMatcher = rowPattern.matcher(input);

        while (rowMatcher.find()) {
            String rowContent = rowMatcher.group(1).trim();
            if (rowContent.isEmpty()) {
                continue;
            }

            String[] tokens = rowContent.split("[,\\s]+");
            List<Integer> values = new ArrayList<>();
            for (String token : tokens) {
                if (!token.isBlank()) {
                    values.add(Integer.parseInt(token.trim()));
                }
            }

            int[] rowArr = new int[values.size()];
            for (int i = 0; i < values.size(); i++) {
                rowArr[i] = values.get(i);
            }
            rowList.add(rowArr);
        }

        return rowList.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        // Read standard input until EOF or matching closing bracket
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            sb.append(line).append(" ");
            if (line.contains("]]")) {
                break;
            }
        }
        scanner.close();

        int[][] grid = parseBracketMatrix(sb.toString());
        RowResult result = busiestRow(grid);
        System.out.println(result);
    }
}