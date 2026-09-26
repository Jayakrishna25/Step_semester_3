package main.java.week_8.assignment_problem;
import java.util.Scanner;

abstract class Employee {
    private final String name;
    private final double monthlySalary;

    public Employee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    public String getName() {
        return this.name;
    }

    public double getMonthlySalary() {
        return this.monthlySalary;
    }

    public abstract double calculateBonus();
}

class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return getMonthlySalary() * 0.10;
    }
}

class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return getMonthlySalary() * 0.05;
    }
}

class InternEmployee extends Employee {
    public InternEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return 2000.0;
    }
}

class FestivalBonusCalculator {

    public static Employee createEmployee(String type, String name, double monthlySalary) {
        switch (type.toUpperCase()) {
            case "FULLTIME":
                return new FullTimeEmployee(name, monthlySalary);
            case "PARTTIME":
                return new PartTimeEmployee(name, monthlySalary);
            case "INTERN":
                return new InternEmployee(name, monthlySalary);
            default:
                throw new IllegalArgumentException("Unknown employee type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            double salary = scanner.nextDouble();
            employees[i] = createEmployee(type, name, salary);
        }

        double grandTotal = 0.0;

        for (Employee employee : employees) {
            double bonus = employee.calculateBonus();
            grandTotal += bonus;
            System.out.printf("%s: %.2f\n", employee.getName(), bonus);
        }

        System.out.printf("Total Bonus: %.2f\n", grandTotal);

        scanner.close();
    }
}
