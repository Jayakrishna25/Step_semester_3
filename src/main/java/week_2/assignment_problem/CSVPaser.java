package main.java.week_2.assignment_problem;
import java.util.Scanner;

class ProductInventoryCsvParser {

    public static void parseInventoryRecord(String csvLine) {
        if (csvLine == null) {
            System.out.println("Invalid Record");
            return;
        }

        String[] fields = csvLine.split(",", -1);

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String productName = fields[0].trim();
        String sku = fields[1].trim();
        String quantity = fields[2].trim();

        if (productName.isEmpty() || sku.isEmpty() || quantity.isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        System.out.printf("Product: %s | SKU: %s | Qty: %s\n", productName, sku, quantity);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter CSV line: ");
        String line = scanner.nextLine();

        parseInventoryRecord(line);

        scanner.close();
    }
}
