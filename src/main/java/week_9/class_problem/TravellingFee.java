package main.java.week_9.class_problem;
import java.util.Scanner;

abstract class TravelBooking {
    private static final double BOOKING_FEE = 50.0;

    private final String mode;
    private final double distanceKm;

    public TravelBooking(String mode, double distanceKm) {
        this.mode = mode;
        this.distanceKm = distanceKm;
    }

    public String getMode() {
        return this.mode;
    }

    public double getDistanceKm() {
        return this.distanceKm;
    }

    public abstract double calculateBaseFare();

    public final double calculateTotalFare() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends TravelBooking {
    public BusBooking(double distanceKm) {
        super("BUS", distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return getDistanceKm() * 2.0;
    }
}

class TrainBooking extends TravelBooking {
    public TrainBooking(double distanceKm) {
        super("TRAIN", distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return getDistanceKm() * 1.5;
    }
}

class FlightBooking extends TravelBooking {
    public FlightBooking(double distanceKm) {
        super("FLIGHT", distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return 2500.0 + (getDistanceKm() * 4.0);
    }
}

class TravelBookingWithCommonFee {

    public static TravelBooking createBooking(String mode, double distanceKm) {
        switch (mode.toUpperCase()) {
            case "BUS":
                return new BusBooking(distanceKm);
            case "TRAIN":
                return new TrainBooking(distanceKm);
            case "FLIGHT":
                return new FlightBooking(distanceKm);
            default:
                throw new IllegalArgumentException("Unknown travel mode: " + mode);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        TravelBooking[] bookings = new TravelBooking[n];

        for (int i = 0; i < n; i++) {
            String mode = scanner.next();
            double distanceKm = scanner.nextDouble();
            bookings[i] = createBooking(mode, distanceKm);
        }

        for (TravelBooking booking : bookings) {
            double totalFare = booking.calculateTotalFare();
            System.out.printf("%s: %.2f\n", booking.getMode(), totalFare);
        }

        scanner.close();
    }
}
