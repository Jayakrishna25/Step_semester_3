package main.java.week_7.class_problem;
class NameTagDemo {

    public static final class NameTag {
        private final String firstName;
        private final char lastInitial;

        public NameTag(String fullName) {
            String[] parts = fullName.split(" ");
            this.firstName = parts[0];
            this.lastInitial = parts[1].charAt(0);
        }

        public String getNickname() {
            return this.firstName + " " + this.lastInitial + ".";
        }

        public String getFirstName() {
            return this.firstName;
        }

        public char getLastInitial() {
            return this.lastInitial;
        }
    }

    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println(tag.getNickname());
    }
}
