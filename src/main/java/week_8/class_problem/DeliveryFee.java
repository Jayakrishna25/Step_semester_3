package main.java.week_8.class_problem;
import java.util.Scanner;

abstract class Delivery {
    private final String typeName;
    private final double weight;
    private final double distance;

    public Delivery(String typeName, double weight, double distance) {
        this.typeName = typeName;
        this.weight = weight;
        this.distance = distance;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public double getWeight() {
        return this.weight;
    }

    public double getDistance() {
        return this.distance;
    }

    public abstract double calculateFee();
}

class StandardDelivery extends Delivery {
    public StandardDelivery(double weight, double distance) {
        super("STANDARD", weight, distance);
    }

    @Override
    public double calculateFee() {
        return 5.0 + (0.50 * getWeight()) + (0.10 * getDistance());
    }
}

class ExpressDelivery extends Delivery {
    public ExpressDelivery(double weight, double distance) {
        super("EXPRESS", weight, distance);
    }

    @Override
    public double calculateFee() {
        return 15.0 + (1.00 * getWeight()) + (0.20 * getDistance());
    }
}

class InternationalDelivery extends Delivery {
    private final double customsFee;

    public InternationalDelivery(double weight, double distance, double customsFee) {
        super("INTERNATIONAL", weight, distance);
        this.customsFee = customsFee;
    }

    public double getCustomsFee() {
        return this.customsFee;
    }

    @Override
    public double calculateFee() {
        return 25.0 + (2.00 * getWeight()) + (0.50 * getDistance()) + this.customsFee;
    }
}

class DeliveryFeeCalculator {

    public static Delivery createDelivery(String[] tokens) {
        String type = tokens[0].toUpperCase();
        double weight = Double.parseDouble(tokens[1]);
        double distance = Double.parseDouble(tokens[2]);

        switch (type) {
            case "STANDARD":
                return new StandardDelivery(weight, distance);
            case "EXPRESS":
                return new ExpressDelivery(weight, distance);
            case "INTERNATIONAL":
                double customsFee = Double.parseDouble(tokens[3]);
                return new InternationalDelivery(weight, distance, customsFee);
            default:
                throw new IllegalArgumentException("Unknown delivery type: " + type);
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

        Delivery[] deliveries = new Delivery[n];

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] tokens = line.split("\\s+");
            deliveries[i] = createDelivery(tokens);
        }

        double grandTotal = 0.0;

        for (Delivery delivery : deliveries) {
            double fee = delivery.calculateFee();
            grandTotal += fee;
            System.out.printf("%s: %.2f\n", delivery.getTypeName(), fee);
        }

        System.out.printf("Total: %.2f\n", grandTotal);

        scanner.close();
    }
}
