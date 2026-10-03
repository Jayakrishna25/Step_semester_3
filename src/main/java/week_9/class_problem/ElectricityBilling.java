package main.java.week_9.class_problem;
import java.util.Scanner;

abstract class ElectricityConnection {
    private final String connectionType;
    private final int units;

    public ElectricityConnection(String connectionType, int units) {
        this.connectionType = connectionType;
        this.units = units;
    }

    public String getConnectionType() {
        return this.connectionType;
    }

    public int getUnits() {
        return this.units;
    }

    public abstract double calculateBill();
}

class HomeConnection extends ElectricityConnection {
    public HomeConnection(int units) {
        super("HOME", units);
    }

    @Override
    public double calculateBill() {
        if (getUnits() <= 100) {
            return getUnits() * 5.0;
        }
        return (100 * 5.0) + ((getUnits() - 100) * 7.0);
    }
}

class ShopConnection extends ElectricityConnection {
    public ShopConnection(int units) {
        super("SHOP", units);
    }

    @Override
    public double calculateBill() {
        return (getUnits() * 8.0) + 100.0;
    }
}

class FactoryConnection extends ElectricityConnection {
    public FactoryConnection(int units) {
        super("FACTORY", units);
    }

    @Override
    public double calculateBill() {
        double standardCharge = getUnits() * 6.0;
        return Math.max(1000.0, standardCharge);
    }
}

class ElectricityConnectionBilling {

    public static ElectricityConnection createConnection(String type, int units) {
        switch (type.toUpperCase()) {
            case "HOME":
                return new HomeConnection(units);
            case "SHOP":
                return new ShopConnection(units);
            case "FACTORY":
                return new FactoryConnection(units);
            default:
                throw new IllegalArgumentException("Unknown connection type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        ElectricityConnection[] connections = new ElectricityConnection[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int units = scanner.nextInt();
            connections[i] = createConnection(type, units);
        }

        double totalAmount = 0.0;

        for (ElectricityConnection connection : connections) {
            double bill = connection.calculateBill();
            totalAmount += bill;
            System.out.printf("%s: %.2f\n", connection.getConnectionType(), bill);
        }

        System.out.printf("Total: %.2f\n", totalAmount);

        scanner.close();
    }
}
