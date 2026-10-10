package main.java.week_10.class_problem;
import java.util.Arrays;
import java.util.Scanner;

class InPlaceArrayReversal {

    public static void reverseInPlace(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextLine()) {
            scanner.close();
            return;
        }

        String line = scanner.nextLine().trim();

        // Strip enclosing square brackets if input is provided as [11, 22, 33, 44]
        if (line.startsWith("[") && line.endsWith("]")) {
            line = line.substring(1, line.length() - 1).trim();
        }

        if (line.isEmpty()) {
            System.out.println("[]");
            scanner.close();
            return;
        }

        String[] parts = line.split("[,\\s]+");
        int[] arr = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }

        reverseInPlace(arr);

        System.out.println(Arrays.toString(arr));

        scanner.close();
    }
}