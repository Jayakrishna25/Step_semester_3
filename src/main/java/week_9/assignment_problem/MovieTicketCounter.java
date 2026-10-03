package main.java.week_9.assignment_problem;
import java.util.Scanner;

abstract class MovieTicket {
    private static final double CONVENIENCE_FEE = 20.0;

    private final String seatType;
    private final int count;

    public MovieTicket(String seatType, int count) {
        this.seatType = seatType;
        this.count = count;
    }

    public String getSeatType() {
        return this.seatType;
    }

    public int getCount() {
        return this.count;
    }

    public abstract double getBasePrice();

    public final double calculateTotalAmount() {
        return this.count * (getBasePrice() + CONVENIENCE_FEE);
    }
}

class RegularTicket extends MovieTicket {
    public RegularTicket(int count) {
        super("REGULAR", count);
    }

    @Override
    public double getBasePrice() {
        return 150.0;
    }
}

class PremiumTicket extends MovieTicket {
    public PremiumTicket(int count) {
        super("PREMIUM", count);
    }

    @Override
    public double getBasePrice() {
        return 250.0;
    }
}

class ReclinerTicket extends MovieTicket {
    public ReclinerTicket(int count) {
        super("RECLINER", count);
    }

    @Override
    public double getBasePrice() {
        return 400.0;
    }
}

class MovieTicketCounter {

    public static MovieTicket createTicket(String seatType, int count) {
        switch (seatType.toUpperCase()) {
            case "REGULAR":
                return new RegularTicket(count);
            case "PREMIUM":
                return new PremiumTicket(count);
            case "RECLINER":
                return new ReclinerTicket(count);
            default:
                throw new IllegalArgumentException("Unknown seat type: " + seatType);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        MovieTicket[] bookings = new MovieTicket[n];

        for (int i = 0; i < n; i++) {
            String seatType = scanner.next();
            int count = scanner.nextInt();
            bookings[i] = createTicket(seatType, count);
        }

        double grandTotal = 0.0;

        for (MovieTicket booking : bookings) {
            double amount = booking.calculateTotalAmount();
            grandTotal += amount;
            System.out.printf("%s: %.2f\n", booking.getSeatType(), amount);
        }

        System.out.printf("Total: %.2f\n", grandTotal);

        scanner.close();
    }
}
