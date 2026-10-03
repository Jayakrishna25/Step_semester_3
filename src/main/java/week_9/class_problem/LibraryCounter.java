package main.java.week_9.class_problem;
import java.util.Scanner;

abstract class BorrowedItem {
    private final String title;
    private final int daysLate;

    public BorrowedItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    public String getTitle() {
        return this.title;
    }

    public int getDaysLate() {
        return this.daysLate;
    }

    public abstract double calculateFine();
}

class BookItem extends BorrowedItem {
    public BookItem(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return getDaysLate() * 2.0;
    }
}

class DvdItem extends BorrowedItem {
    public DvdItem(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        double fine = getDaysLate() * 5.0;
        return Math.min(50.0, fine);
    }
}

class MagazineItem extends BorrowedItem {
    public MagazineItem(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return getDaysLate() * 1.0;
    }
}

class LibraryLateFineCounter {

    public static BorrowedItem createItem(String[] tokens) {
        String type = tokens[0].toUpperCase();
        String title = tokens[1];
        int daysLate = Integer.parseInt(tokens[2]);

        switch (type) {
            case "BOOK":
                return new BookItem(title, daysLate);
            case "DVD":
                return new DvdItem(title, daysLate);
            case "MAGAZINE":
                return new MagazineItem(title, daysLate);
            default:
                throw new IllegalArgumentException("Unknown item type: " + type);
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

        BorrowedItem[] items = new BorrowedItem[n];

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] tokens = line.split("\\s+");
            items[i] = createItem(tokens);
        }

        double totalFines = 0.0;

        for (BorrowedItem item : items) {
            double fine = item.calculateFine();
            totalFines += fine;
            System.out.printf("%s: %.2f\n", item.getTitle(), fine);
        }

        System.out.printf("Total Fines: %.2f\n", totalFines);

        scanner.close();
    }
}
