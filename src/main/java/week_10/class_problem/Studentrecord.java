package main.java.week_10.class_problem;
import java.util.Scanner;

class StudentRecord {
    private final String name;
    private final double[] marks;

    public StudentRecord(String name, double[] marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return this.name;
    }

    public double calculateAverage() {
        if (this.marks == null || this.marks.length == 0) {
            return 0.0;
        }
        double sum = 0.0;
        for (double mark : this.marks) {
            sum += mark;
        }
        return sum / this.marks.length;
    }

    public char determineGrade() {
        double avg = calculateAverage();
        if (avg >= 75.0) {
            return 'B';
        } else if (avg >= 60.0) {
            return 'C';
        } else if (avg >= 40.0) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public void printResultCard() {
        System.out.printf("%s: Average %.1f, Grade %c\n",
                this.name.toUpperCase(),
                calculateAverage(),
                determineGrade());
    }
}

class StudentResultCardGenerator {

    public static StudentRecord parseStudentRecord(String line) {
        line = line.trim();
        int bracketStart = line.indexOf('[');
        int bracketEnd = line.indexOf(']');

        String name = line.substring(0, bracketStart).trim();
        String marksContent = line.substring(bracketStart + 1, bracketEnd).trim();

        String[] markTokens = marksContent.split("[,\\s]+");
        double[] marks = new double[markTokens.length];
        for (int i = 0; i < markTokens.length; i++) {
            marks[i] = Double.parseDouble(markTokens[i]);
        }

        return new StudentRecord(name, marks);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            StudentRecord student = parseStudentRecord(line);
            student.printResultCard();
        }

        scanner.close();
    }
}
