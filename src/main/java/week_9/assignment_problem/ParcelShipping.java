package main.java.week_9.assignment_problem;
import java.util.Scanner;

interface Insurable {
    double calculateInsurance();
}

abstract class Parcel {
    private final String type;
    private final double weightKg;
    private final double declaredValue;

    public Parcel(String type, double weightKg, double declaredValue) {
        this.type = type;
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    public String getType() {
        return this.type;
    }

    public double getWeightKg() {
        return this.weightKg;
    }

    public double getDeclaredValue() {
        return this.declaredValue;
    }

    public abstract double calculateShippingCharge();

    public double calculateInsuranceAmount() {
        if (this instanceof Insurable) {
            return ((Insurable) this).calculateInsurance();
        }
        return 0.0;
    }

    public double calculateTotal() {
        return calculateShippingCharge() + calculateInsuranceAmount();
    }
}

class StandardParcel extends Parcel {
    public StandardParcel(double weightKg, double declaredValue) {
        super("STANDARD", weightKg, declaredValue);
    }

    @Override
    public double calculateShippingCharge() {
        return 40.0 + (10.0 * getWeightKg());
    }
}

class ExpressParcel extends Parcel implements Insurable {
    public ExpressParcel(double weightKg, double declaredValue) {
        super("EXPRESS", weightKg, declaredValue);
    }

    @Override
    public double calculateShippingCharge() {
        return 80.0 + (15.0 * getWeightKg());
    }

    @Override
    public double calculateInsurance() {
        return getDeclaredValue() * 0.02;
    }
}

class FragileParcel extends Parcel implements Insurable {
    public FragileParcel(double weightKg, double declaredValue) {
        super("FRAGILE", weightKg, declaredValue);
    }

    @Override
    public double calculateShippingCharge() {
        double standardCharge = 40.0 + (10.0 * getWeightKg());
        return standardCharge + 50.0;
    }

    @Override
    public double calculateInsurance() {
        return getDeclaredValue() * 0.02;
    }
}

class ParcelShippingDesk {

    public static Parcel createParcel(String[] tokens) {
        String type = tokens[0].toUpperCase();
        double weightKg = Double.parseDouble(tokens[1]);
        double declaredValue = Double.parseDouble(tokens[2]);

        switch (type) {
            case "STANDARD":
                return new StandardParcel(weightKg, declaredValue);
            case "EXPRESS":
                return new ExpressParcel(weightKg, declaredValue);
            case "FRAGILE":
                return new FragileParcel(weightKg, declaredValue);
            default:
                throw new IllegalArgumentException("Unknown parcel type: " + type);
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

        Parcel[] parcels = new Parcel[n];

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] tokens = line.split("\\s+");
            parcels[i] = createParcel(tokens);
        }

        double grandTotal = 0.0;

        for (Parcel parcel : parcels) {
            double charge = parcel.calculateShippingCharge();
            double insurance = parcel.calculateInsuranceAmount();
            double total = parcel.calculateTotal();
            grandTotal += total;

            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f\n",
                    parcel.getType(), charge, insurance, total);
        }

        System.out.printf("Grand Total: %.2f\n", grandTotal);

        scanner.close();
    }
}