package main.java.week_8.assignment_problem;
import java.util.Scanner;

abstract class Customer {
    private final String customerType;
    private final double amount;

    public Customer(String customerType, double amount) {
        this.customerType = customerType;
        this.amount = amount;
    }

    public String getCustomerType() {
        return this.customerType;
    }

    public double getAmount() {
        return this.amount;
    }

    public abstract double calculateFinalAmount();
}

class StudentCustomer extends Customer {
    public StudentCustomer(double amount) {
        super("STUDENT", amount);
    }

    @Override
    public double calculateFinalAmount() {
        return getAmount() * 0.90;
    }
}

class StaffCustomer extends Customer {
    public StaffCustomer(double amount) {
        super("STAFF", amount);
    }

    @Override
    public double calculateFinalAmount() {
        return getAmount() * 0.95;
    }
}

class GuestCustomer extends Customer {
    public GuestCustomer(double amount) {
        super("GUEST", amount);
    }

    @Override
    public double calculateFinalAmount() {
        return getAmount() + 10.0;
    }
}

class CanteenBillingCounter {

    public static Customer createCustomer(String type, double amount) {
        switch (type.toUpperCase()) {
            case "STUDENT":
                return new StudentCustomer(amount);
            case "STAFF":
                return new StaffCustomer(amount);
            case "GUEST":
                return new GuestCustomer(amount);
            default:
                throw new IllegalArgumentException("Unknown customer type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        Customer[] bills = new Customer[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();
            bills[i] = createCustomer(type, amount);
        }

        double grandTotal = 0.0;

        for (Customer bill : bills) {
            double finalAmount = bill.calculateFinalAmount();
            grandTotal += finalAmount;
            System.out.printf("%s: %.2f\n", bill.getCustomerType(), finalAmount);
        }

        System.out.printf("Total: %.2f\n", grandTotal);

        scanner.close();
    }
}
