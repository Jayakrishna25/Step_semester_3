package main.java.week_9.assignment_problem;
import java.util.Scanner;

interface BusCommuter {
    double TRANSPORT_FEE = 12000.0;

    default double getTransportFee() {
        return TRANSPORT_FEE;
    }
}

abstract class Student {
    private final String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public abstract double calculateTuitionAndHostel();

    public final double calculateTotalFee() {
        double fee = calculateTuitionAndHostel();
        if (this instanceof BusCommuter) {
            fee += ((BusCommuter) this).getTransportFee();
        }
        return fee;
    }
}

class DayScholarStudent extends Student implements BusCommuter {
    public DayScholarStudent(String name) {
        super(name);
    }

    @Override
    public double calculateTuitionAndHostel() {
        return 40000.0;
    }
}

class HostellerStudent extends Student {
    public HostellerStudent(String name) {
        super(name);
    }

    @Override
    public double calculateTuitionAndHostel() {
        return 40000.0 + 60000.0;
    }
}

class ScholarshipStudent extends Student implements BusCommuter {
    public ScholarshipStudent(String name) {
        super(name);
    }

    @Override
    public double calculateTuitionAndHostel() {
        return 20000.0;
    }
}

class CollegeFeeCounter {

    public static Student createStudent(String type, String name) {
        switch (type.toUpperCase()) {
            case "DAY_SCHOLAR":
                return new DayScholarStudent(name);
            case "HOSTELLER":
                return new HostellerStudent(name);
            case "SCHOLAR":
                return new ScholarshipStudent(name);
            default:
                throw new IllegalArgumentException("Unknown student type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            students[i] = createStudent(type, name);
        }

        double totalCollected = 0.0;

        for (Student student : students) {
            double fee = student.calculateTotalFee();
            totalCollected += fee;
            System.out.printf("%s: %.2f\n", student.getName(), fee);
        }

        System.out.printf("Total Collected: %.2f\n", totalCollected);

        scanner.close();
    }
}
