package main.java.week_9.class_problem;
import java.util.Scanner;

abstract class StaffMember {
    private final String name;

    public StaffMember(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public abstract double calculatePay();
}

class FullTimeStaff extends StaffMember {
    private final double weeklySalary;

    public FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    public double getWeeklySalary() {
        return this.weeklySalary;
    }

    @Override
    public double calculatePay() {
        return this.weeklySalary;
    }
}

class HourlyStaff extends StaffMember {
    private final double hours;
    private final double rate;

    public HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    public double getHours() {
        return this.hours;
    }

    public double getRate() {
        return this.rate;
    }

    @Override
    public double calculatePay() {
        if (this.hours <= 40) {
            return this.hours * this.rate;
        }
        double regularPay = 40 * this.rate;
        double overtimeHours = this.hours - 40;
        double overtimePay = overtimeHours * this.rate * 1.5;
        return regularPay + overtimePay;
    }
}

class InternStaff extends StaffMember {
    private final double stipend;

    public InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    public double getStipend() {
        return this.stipend;
    }

    @Override
    public double calculatePay() {
        return this.stipend;
    }
}

class WeeklyStaffPay {

    public static StaffMember createStaffMember(String[] tokens) {
        String type = tokens[0].toUpperCase();
        String name = tokens[1];

        switch (type) {
            case "FULLTIME":
                double weeklySalary = Double.parseDouble(tokens[2]);
                return new FullTimeStaff(name, weeklySalary);
            case "HOURLY":
                double hours = Double.parseDouble(tokens[2]);
                double rate = Double.parseDouble(tokens[3]);
                return new HourlyStaff(name, hours, rate);
            case "INTERN":
                double stipend = Double.parseDouble(tokens[2]);
                return new InternStaff(name, stipend);
            default:
                throw new IllegalArgumentException("Unknown staff type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        scanner.nextLine();

        StaffMember[] staffMembers = new StaffMember[n];

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] tokens = line.split("\\s+");
            staffMembers[i] = createStaffMember(tokens);
        }

        double totalPayroll = 0.0;

        for (StaffMember staff : staffMembers) {
            double pay = staff.calculatePay();
            totalPayroll += pay;
            System.out.printf("%s: %.2f\n", staff.getName(), pay);
        }

        System.out.printf("Total Payroll: %.2f\n", totalPayroll);

        scanner.close();
    }
}
