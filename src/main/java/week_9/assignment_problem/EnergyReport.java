package main.java.week_9.assignment_problem;
import java.util.Scanner;

interface EnergySaverCapable {
}

abstract class Appliance {
    private static final double COST_PER_UNIT = 8.0;

    private final String applianceType;
    private final double hours;
    private final boolean saverRequested;

    public Appliance(String applianceType, double hours, boolean saverRequested) {
        this.applianceType = applianceType;
        this.hours = hours;
        this.saverRequested = saverRequested;
    }

    public String getApplianceType() {
        return this.applianceType;
    }

    public double getHours() {
        return this.hours;
    }

    public boolean isSaverRequested() {
        return this.saverRequested;
    }

    public abstract double getPowerRatingWatts();

    public boolean isConfigurationValid() {
        if (this.saverRequested) {
            return this instanceof EnergySaverCapable;
        }
        return true;
    }

    public double calculateUnits() {
        double rawUnits = (getPowerRatingWatts() * this.hours) / 1000.0;
        if (this.saverRequested) {
            return rawUnits * 0.75;
        }
        return rawUnits;
    }

    public double calculateCost() {
        return calculateUnits() * COST_PER_UNIT;
    }
}

class Fridge extends Appliance {
    public Fridge(double hours, boolean saverRequested) {
        super("FRIDGE", hours, saverRequested);
    }

    @Override
    public double getPowerRatingWatts() {
        return 150.0;
    }
}

class AirConditioner extends Appliance implements EnergySaverCapable {
    public AirConditioner(double hours, boolean saverRequested) {
        super("AC", hours, saverRequested);
    }

    @Override
    public double getPowerRatingWatts() {
        return 1500.0;
    }
}

class Television extends Appliance {
    public Television(double hours, boolean saverRequested) {
        super("TV", hours, saverRequested);
    }

    @Override
    public double getPowerRatingWatts() {
        return 100.0;
    }
}

class WashingMachine extends Appliance implements EnergySaverCapable {
    public WashingMachine(double hours, boolean saverRequested) {
        super("WASHER", hours, saverRequested);
    }

    @Override
    public double getPowerRatingWatts() {
        return 500.0;
    }
}

class HomeApplianceEnergyReport {

    public static Appliance createAppliance(String[] tokens) {
        String type = tokens[0].toUpperCase();
        double hours = Double.parseDouble(tokens[1]);
        boolean saver = tokens.length > 2 && "SAVER".equalsIgnoreCase(tokens[2]);

        switch (type) {
            case "FRIDGE":
                return new Fridge(hours, saver);
            case "AC":
                return new AirConditioner(hours, saver);
            case "TV":
                return new Television(hours, saver);
            case "WASHER":
                return new WashingMachine(hours, saver);
            default:
                throw new IllegalArgumentException("Unknown appliance type: " + type);
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

        Appliance[] appliances = new Appliance[n];

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] tokens = line.split("\\s+");
            appliances[i] = createAppliance(tokens);
        }

        double totalCost = 0.0;

        for (Appliance appliance : appliances) {
            if (appliance.isConfigurationValid()) {
                double units = appliance.calculateUnits();
                double cost = appliance.calculateCost();
                totalCost += cost;
                System.out.printf("%s: Units=%.2f Cost=%.2f\n", appliance.getApplianceType(), units, cost);
            } else {
                System.out.printf("%s: saver mode not supported\n", appliance.getApplianceType());
            }
        }

        System.out.printf("Total Cost: %.2f\n", totalCost);

        scanner.close();
    }
}
