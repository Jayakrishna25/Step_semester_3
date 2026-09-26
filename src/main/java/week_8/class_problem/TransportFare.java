package main.java.week_8.class_problem;
import java.util.Scanner;

abstract class TransportJourney {
    private final String transportType;
    private final double distance;

    public TransportJourney(String transportType, double distance) {
        this.transportType = transportType;
        this.distance = distance;
    }

    public String getTransportType() {
        return this.transportType;
    }

    public double getDistance() {
        return this.distance;
    }

    public abstract double calculateFare();
}

class BusJourney extends TransportJourney {
    public BusJourney(double distance) {
        super("BUS", distance);
    }

    @Override
    public double calculateFare() {
        double fare = 2.0 + (0.10 * getDistance());
        return Math.min(10.0, fare);
    }
}

class TrainJourney extends TransportJourney {
    public TrainJourney(double distance) {
        super("TRAIN", distance);
    }

    @Override
    public double calculateFare() {
        return 3.0 + (0.15 * getDistance());
    }
}

class MetroJourney extends TransportJourney {
    private final double peakHourFactor;

    public MetroJourney(double distance, double peakHourFactor) {
        super("METRO", distance);
        this.peakHourFactor = peakHourFactor;
    }

    public double getPeakHourFactor() {
        return this.peakHourFactor;
    }

    @Override
    public double calculateFare() {
        return (1.50 + (0.20 * getDistance())) * this.peakHourFactor;
    }
}

class PublicTransportFareCalculator {

    public static TransportJourney createJourney(String[] tokens) {
        String type = tokens[0].toUpperCase();
        double distance = Double.parseDouble(tokens[1]);

        switch (type) {
            case "BUS":
                return new BusJourney(distance);
            case "TRAIN":
                return new TrainJourney(distance);
            case "METRO":
                double peakHourFactor = Double.parseDouble(tokens[2]);
                return new MetroJourney(distance, peakHourFactor);
            default:
                throw new IllegalArgumentException("Unknown transport type: " + type);
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

        TransportJourney[] journeys = new TransportJourney[n];

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] tokens = line.split("\\s+");
            journeys[i] = createJourney(tokens);
        }

        double grandTotal = 0.0;

        for (TransportJourney journey : journeys) {
            double fare = journey.calculateFare();
            grandTotal += fare;
            System.out.printf("%s: %.2f\n", journey.getTransportType(), fare);
        }

        System.out.printf("Total: %.2f\n", grandTotal);

        scanner.close();
    }
}