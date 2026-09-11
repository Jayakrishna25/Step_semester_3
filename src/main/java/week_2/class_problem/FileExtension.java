package main.java.week_2.class_problem;
import java.util.Scanner;

class FileExtensionValidator {

    public static String validateFileExtension(String filename) {
        if (filename == null || filename.trim().isEmpty()) {
            return "Rejected — invalid file type";
        }

        int dotIndex = filename.lastIndexOf('.');

        if (dotIndex == -1 || dotIndex == filename.length() - 1) {
            return "Rejected — invalid file type";
        }

        String extension = filename.substring(dotIndex + 1);

        if (extension.equalsIgnoreCase("pdf") ||
                extension.equalsIgnoreCase("docx") ||
                extension.equalsIgnoreCase("zip")) {
            return "Accepted";
        }

        return "Rejected — invalid file type";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter filename: ");
        String filename = scanner.nextLine();

        String result = validateFileExtension(filename);
        System.out.println(result);

        scanner.close();
    }
}