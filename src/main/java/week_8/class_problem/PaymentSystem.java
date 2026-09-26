package main.java.week_8.class_problem;
import java.util.Scanner;

abstract class Payment {
    private final String typeName;
    private final double amount;

    public Payment(String typeName, double amount) {
        this.typeName = typeName;
        this.amount = amount;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public double getAmount() {
        return this.amount;
    }

    public abstract double calculateFinalAmount();
}

class CardPayment extends Payment {
    public CardPayment(double amount) {
        super("CARD", amount);
    }

    @Override
    public double calculateFinalAmount() {
        return getAmount() * 1.02;
    }
}

class WalletPayment extends Payment {
    public WalletPayment(double amount) {
        super("WALLET", amount);
    }

    @Override
    public double calculateFinalAmount() {
        return getAmount() * 1.01;
    }
}

class BankTransferPayment extends Payment {
    public BankTransferPayment(double amount) {
        super("BANKTRANSFER", amount);
    }

    @Override
    public double calculateFinalAmount() {
        return getAmount();
    }
}

class PaymentSystemFeeCalculation {

    public static Payment createPayment(String type, double amount) {
        switch (type.toUpperCase()) {
            case "CARD":
                return new CardPayment(amount);
            case "WALLET":
                return new WalletPayment(amount);
            case "BANKTRANSFER":
                return new BankTransferPayment(amount);
            default:
                throw new IllegalArgumentException("Unknown payment type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        Payment[] transactions = new Payment[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();
            transactions[i] = createPayment(type, amount);
        }

        double grandTotal = 0.0;

        for (Payment payment : transactions) {
            double finalAmount = payment.calculateFinalAmount();
            grandTotal += finalAmount;
            System.out.printf("%s: %.2f\n", payment.getTypeName(), finalAmount);
        }

        System.out.printf("Total: %.2f\n", grandTotal);

        scanner.close();
    }
}