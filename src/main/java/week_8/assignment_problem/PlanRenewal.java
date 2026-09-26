package main.java.week_8.assignment_problem;
import java.time.LocalDate;
import java.util.Scanner;

abstract class SubscriptionPlan {
    private final String name;
    private final LocalDate startDate;

    public SubscriptionPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public String getName() {
        return this.name;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public abstract int getValidityDays();

    public LocalDate calculateRenewalDate() {
        return this.startDate.plusDays(getValidityDays());
    }
}

class BasicPlan extends SubscriptionPlan {
    public BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public int getValidityDays() {
        return 30;
    }
}

class StandardPlan extends SubscriptionPlan {
    public StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public int getValidityDays() {
        return 90;
    }
}

class PremiumPlan extends SubscriptionPlan {
    public PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public int getValidityDays() {
        return 365;
    }
}

class StreamingPlanRenewalReminder {

    public static SubscriptionPlan createPlan(String planType, String name, LocalDate startDate) {
        switch (planType.toUpperCase()) {
            case "BASIC":
                return new BasicPlan(name, startDate);
            case "STANDARD":
                return new StandardPlan(name, startDate);
            case "PREMIUM":
                return new PremiumPlan(name, startDate);
            default:
                throw new IllegalArgumentException("Unknown plan type: " + planType);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        SubscriptionPlan[] subscriptions = new SubscriptionPlan[n];

        for (int i = 0; i < n; i++) {
            String planType = scanner.next();
            String name = scanner.next();
            LocalDate startDate = LocalDate.parse(scanner.next());
            subscriptions[i] = createPlan(planType, name, startDate);
        }

        for (SubscriptionPlan subscription : subscriptions) {
            LocalDate renewalDate = subscription.calculateRenewalDate();
            System.out.println(subscription.getName() + ": " + renewalDate);
        }

        scanner.close();
    }
}
