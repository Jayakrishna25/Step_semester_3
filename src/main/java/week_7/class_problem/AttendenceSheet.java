package main.java.week_7.class_problem;
class AttendanceSheetDemo {

    public static class AttendanceSheet {
        private final String[] presentStudents;
        private int count;

        public AttendanceSheet(int maxCapacity) {
            if (maxCapacity < 0) {
                this.presentStudents = new String[0];
            } else {
                this.presentStudents = new String[maxCapacity];
            }
            this.count = 0;
        }

        public boolean isPresent(String name) {
            if (name == null) {
                return false;
            }
            for (int i = 0; i < count; i++) {
                if (presentStudents[i].equals(name)) {
                    return true;
                }
            }
            return false;
        }

        public void markPresent(String name) {
            if (name == null || isPresent(name)) {
                return;
            }
            if (count < presentStudents.length) {
                presentStudents[count++] = name;
            }
        }

        public int getPresentCount() {
            return this.count;
        }
    }

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("sheet.getPresentCount() -> " + sheet.getPresentCount());
        System.out.println("sheet.isPresent(\"Ben\") -> " + sheet.isPresent("Ben"));
        System.out.println("sheet.isPresent(\"Chen\") -> " + sheet.isPresent("Chen"));
    }
}
