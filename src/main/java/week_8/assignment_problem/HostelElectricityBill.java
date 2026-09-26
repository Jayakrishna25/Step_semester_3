package main.java.week_8.assignment_problem;
import java.util.Scanner;

abstract class Room {
    private final String roomType;
    private final int units;

    public Room(String roomType, int units) {
        this.roomType = roomType;
        this.units = units;
    }

    public String getRoomType() {
        return this.roomType;
    }

    public int getUnits() {
        return this.units;
    }

    public abstract double calculateBill();
}

class SingleRoom extends Room {
    public SingleRoom(int units) {
        super("SINGLE", units);
    }

    @Override
    public double calculateBill() {
        return getUnits() * 8.0;
    }
}

class SharedRoom extends Room {
    private final int occupants;

    public SharedRoom(int units, int occupants) {
        super("SHARED", units);
        this.occupants = occupants;
    }

    public int getOccupants() {
        return this.occupants;
    }

    @Override
    public double calculateBill() {
        return (getUnits() * 6.0) / this.occupants;
    }
}

class AcRoom extends Room {
    public AcRoom(int units) {
        super("AC", units);
    }

    @Override
    public double calculateBill() {
        return (getUnits() * 10.0) + 200.0;
    }
}

class HostelElectricityBill {

    public static Room createRoom(String[] tokens) {
        String type = tokens[0].toUpperCase();
        int units = Integer.parseInt(tokens[1]);

        switch (type) {
            case "SINGLE":
                return new SingleRoom(units);
            case "SHARED":
                int occupants = Integer.parseInt(tokens[2]);
                return new SharedRoom(units, occupants);
            case "AC":
                return new AcRoom(units);
            default:
                throw new IllegalArgumentException("Unknown room type: " + type);
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

        Room[] rooms = new Room[n];

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] tokens = line.split("\\s+");
            rooms[i] = createRoom(tokens);
        }

        double grandTotal = 0.0;

        for (Room room : rooms) {
            double bill = room.calculateBill();
            grandTotal += bill;
            System.out.printf("%s: %.2f\n", room.getRoomType(), bill);
        }

        System.out.printf("Total: %.2f\n", grandTotal);

        scanner.close();
    }
}
