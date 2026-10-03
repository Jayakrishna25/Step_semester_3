package main.java.week_9.assignment_problem;
import java.util.Scanner;

interface NightServiceable {
}

abstract class CityCab {
    private static final double MINIMUM_FARE = 100.0;

    private final String cabType;
    private final double distanceKm;
    private final String timeOfDay;

    public CityCab(String cabType, double distanceKm, String timeOfDay) {
        this.cabType = cabType;
        this.distanceKm = distanceKm;
        this.timeOfDay = timeOfDay;
    }

    public String getCabType() {
        return this.cabType;
    }

    public double getDistanceKm() {
        return this.distanceKm;
    }

    public String getTimeOfDay() {
        return this.timeOfDay;
    }

    public abstract double getRatePerKm();

    public boolean canFulfillTrip() {
        if ("NIGHT".equalsIgnoreCase(this.timeOfDay)) {
            return this instanceof NightServiceable;
        }
        return true;
    }

    public double calculateFare() {
        double rawFare = this.distanceKm * getRatePerKm();
        double baseFare = Math.max(MINIMUM_FARE, rawFare);

        if ("NIGHT".equalsIgnoreCase(this.timeOfDay)) {
            return baseFare * 1.20;
        }
        return baseFare;
    }
}

class MiniCab extends CityCab {
    public MiniCab(double distanceKm, String timeOfDay) {
        super("MINI", distanceKm, timeOfDay);
    }

    @Override
    public double getRatePerKm() {
        return 10.0;
    }
}

class SedanCab extends CityCab implements NightServiceable {
    public SedanCab(double distanceKm, String timeOfDay) {
        super("SEDAN", distanceKm, timeOfDay);
    }

    @Override
    public double getRatePerKm() {
        return 14.0;
    }
}

class SuvCab extends CityCab implements NightServiceable {
    public SuvCab(double distanceKm, String timeOfDay) {
        super("SUV", distanceKm, timeOfDay);
    }

    @Override
    public double getRatePerKm() {
        return 18.0;
    }
}

class CityCabFareMeter {

    public static CityCab createCab(String type, double distanceKm, String timeOfDay) {
        switch (type.toUpperCase()) {
            case "MINI":
                return new MiniCab(distanceKm, timeOfDay);
            case "SEDAN":
                return new SedanCab(distanceKm, timeOfDay);
            case "SUV":
                return new SuvCab(distanceKm, timeOfDay);
            default:
                throw new IllegalArgumentException("Unknown cab type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        CityCab[] cabs = new CityCab[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double distanceKm = scanner.nextDouble();
            String timeOfDay = scanner.next();
            cabs[i] = createCab(type, distanceKm, timeOfDay);
        }

        double totalCollected = 0.0;

        for (CityCab cab : cabs) {
            if (cab.canFulfillTrip()) {
                double fare = cab.calculateFare();
                totalCollected += fare;
                System.out.printf("%s: %.2f\n", cab.getCabType(), fare);
            } else {
                System.out.printf("%s: night service not available\n", cab.getCabType());
            }
        }

        System.out.printf("Total: %.2f\n", totalCollected);

        scanner.close();
    }
}
