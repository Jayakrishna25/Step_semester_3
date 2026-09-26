package main.java.week_8.assignment_problem;
import java.util.Scanner;

abstract class Vehicle {
    private final String vehicleType;
    private final int hours;

    public Vehicle(String vehicleType, int hours) {
        this.vehicleType = vehicleType;
        this.hours = hours;
    }

    public String getVehicleType() {
        return this.vehicleType;
    }

    public int getHours() {
        return this.hours;
    }

    public abstract double calculateParkingCharge();
}

class BikeVehicle extends Vehicle {
    public BikeVehicle(int hours) {
        super("BIKE", hours);
    }

    @Override
    public double calculateParkingCharge() {
        return getHours() * 10.0;
    }
}

class CarVehicle extends Vehicle {
    public CarVehicle(int hours) {
        super("CAR", hours);
    }

    @Override
    public double calculateParkingCharge() {
        return 30.0 + (getHours() - 1) * 20.0;
    }
}

class TruckVehicle extends Vehicle {
    public TruckVehicle(int hours) {
        super("TRUCK", hours);
    }

    @Override
    public double calculateParkingCharge() {
        double standardCharge = getHours() * 50.0;
        return Math.max(100.0, standardCharge);
    }
}

class CampusParkingChargeCalculator {

    public static Vehicle createVehicle(String type, int hours) {
        switch (type.toUpperCase()) {
            case "BIKE":
                return new BikeVehicle(hours);
            case "CAR":
                return new CarVehicle(hours);
            case "TRUCK":
                return new TruckVehicle(hours);
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        Vehicle[] vehicles = new Vehicle[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int hours = scanner.nextInt();
            vehicles[i] = createVehicle(type, hours);
        }

        double grandTotal = 0.0;

        for (Vehicle vehicle : vehicles) {
            double charge = vehicle.calculateParkingCharge();
            grandTotal += charge;
            System.out.printf("%s: %.2f\n", vehicle.getVehicleType(), charge);
        }

        System.out.printf("Total: %.2f\n", grandTotal);

        scanner.close();
    }
}
