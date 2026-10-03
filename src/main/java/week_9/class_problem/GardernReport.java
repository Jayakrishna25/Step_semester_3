package main.java.week_9.class_problem;
import java.util.Scanner;

abstract class GardenPlot {
    private final String shapeName;
    private final String owner;

    public GardenPlot(String shapeName, String owner) {
        this.shapeName = shapeName;
        this.owner = owner;
    }

    public String getShapeName() {
        return this.shapeName;
    }

    public String getOwner() {
        return this.owner;
    }

    public abstract double calculateArea();
}

class CirclePlot extends GardenPlot {
    private final double radius;

    public CirclePlot(String owner, double radius) {
        super("CIRCLE", owner);
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class RectanglePlot extends GardenPlot {
    private final double length;
    private final double width;

    public RectanglePlot(String owner, double length, double width) {
        super("RECTANGLE", owner);
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return this.length;
    }

    public double getWidth() {
        return this.width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}

class TrianglePlot extends GardenPlot {
    private final double base;
    private final double height;

    public TrianglePlot(String owner, double base, double height) {
        super("TRIANGLE", owner);
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return this.base;
    }

    public double getHeight() {
        return this.height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

class GardenPlotAreaReport {

    public static GardenPlot createPlot(String[] tokens) {
        String shape = tokens[0].toUpperCase();
        String owner = tokens[1];

        switch (shape) {
            case "CIRCLE":
                double radius = Double.parseDouble(tokens[2]);
                return new CirclePlot(owner, radius);
            case "RECTANGLE":
                double length = Double.parseDouble(tokens[2]);
                double width = Double.parseDouble(tokens[3]);
                return new RectanglePlot(owner, length, width);
            case "TRIANGLE":
                double base = Double.parseDouble(tokens[2]);
                double height = Double.parseDouble(tokens[3]);
                return new TrianglePlot(owner, base, height);
            default:
                throw new IllegalArgumentException("Unknown plot shape: " + shape);
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

        GardenPlot[] plots = new GardenPlot[n];

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] tokens = line.split("\\s+");
            plots[i] = createPlot(tokens);
        }

        double totalArea = 0.0;

        for (GardenPlot plot : plots) {
            double area = plot.calculateArea();
            totalArea += area;
            System.out.printf("%s (%s): %.2f\n", plot.getOwner(), plot.getShapeName(), area);
        }

        System.out.printf("Total Area: %.2f\n", totalArea);

        scanner.close();
    }
}
