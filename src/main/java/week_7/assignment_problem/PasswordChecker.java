package main.java.week_7.assignment_problem;
class PasswordCheckerDemo {

    public static class PasswordChecker {
        private final String password;

        public PasswordChecker(String password) {
            this.password = (password == null) ? "" : password;
        }

        public String getStrength() {
            int length = password.length();

            if (length < 6) {
                return "Weak";
            } else if (length <= 9) {
                return "Medium";
            } else {
                return "Strong";
            }
        }
    }

    public static void main(String[] args) {
        PasswordChecker pc1 = new PasswordChecker("abcd");
        System.out.println("pc.getStrength() -> \"" + pc1.getStrength() + "\"");

        PasswordChecker pc2 = new PasswordChecker("secret12");
        System.out.println("pc2.getStrength() -> \"" + pc2.getStrength() + "\"");

        PasswordChecker pc3 = new PasswordChecker("abcdefghij");
        System.out.println("pc3.getStrength() -> \"" + pc3.getStrength() + "\"");
    }
}
