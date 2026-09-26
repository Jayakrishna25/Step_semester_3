package main.java.week_8.class_problem;
import java.time.LocalDate;
import java.util.Scanner;

abstract class LibraryItem {
    private final String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public abstract int getBorrowingDays();

    public LocalDate calculateDueDate(LocalDate checkoutDate) {
        return checkoutDate.plusDays(getBorrowingDays());
    }
}

class BookItem extends LibraryItem {
    public BookItem(String title) {
        super(title);
    }

    @Override
    public int getBorrowingDays() {
        return 14;
    }
}

class DvdItem extends LibraryItem {
    public DvdItem(String title) {
        super(title);
    }

    @Override
    public int getBorrowingDays() {
        return 7;
    }
}

class MagazineItem extends LibraryItem {
    public MagazineItem(String title) {
        super(title);
    }

    @Override
    public int getBorrowingDays() {
        return 3;
    }
}

class LibraryDueDateCalculator {

    public static LibraryItem createItem(String type, String title) {
        switch (type.toUpperCase()) {
            case "BOOK":
                return new BookItem(title);
            case "DVD":
                return new DvdItem(title);
            case "MAGAZINE":
                return new MagazineItem(title);
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

        LibraryItem[] items = new LibraryItem[n];
        LocalDate baseDate = LocalDate.of(2023, 10, 26);

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            int firstSpace = line.indexOf(' ');
            String type = line.substring(0, firstSpace);
            String rawTitle = line.substring(firstSpace + 1).trim();

            if (rawTitle.startsWith("\"") && rawTitle.endsWith("\"")) {
                rawTitle = rawTitle.substring(1, rawTitle.length() - 1);
            }

            items[i] = createItem(type, rawTitle);
        }

        for (LibraryItem item : items) {
            LocalDate dueDate = item.calculateDueDate(baseDate);
            System.out.println(item.getTitle() + ": " + dueDate);
        }

        scanner.close();
    }
}