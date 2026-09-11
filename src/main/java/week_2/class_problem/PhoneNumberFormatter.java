package main.java.week_2.class_problem;
import java.util.Scanner;

class MaskedPhoneNumberFormatter {

    public static String maskPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10) {
            return "Invalid phone number";
        }

        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        StringBuilder masked = new StringBuilder();
        masked.append("XXXXXX");
        masked.append(phone.substring(6));
        masked.insert(6, "-");

        return masked.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine().trim();

        String result = maskPhoneNumber(phone);
        System.out.println(result);

        scanner.close();
    }
}