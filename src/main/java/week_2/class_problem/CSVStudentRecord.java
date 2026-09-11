package main.java.week_2.class_problem;
import java.util.Scanner;

class StudentRecordParser {

    public static void parseStudentRecord(String csvLine) {
        if (csvLine == null) {
            System.out.println("Invalid Record");
            return;
        }

        String[] fields = csvLine.split(",", -1);

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String name = fields[0].trim();
        String rollNumber = fields[1].trim();
        String department = fields[2].trim();

        if (name.isEmpty() || rollNumber.isEmpty() || department.isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        System.out.printf("Name: %s | Roll No: %s | Dept: %s\n", name, rollNumber, department);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter CSV record (Name,RollNumber,Department): ");
        String line = scanner.nextLine();

        parseStudentRecord(line);

        scanner.close();
    }
}
