package main.java.week_7.class_problem;
class PiggyBank {
    private final String id;
    private double savings;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0.0;
    }

    public String getId() {
        return this.id;
    }

    public double getSavings() {
        return this.savings;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit rejected: amount must be greater than 0");
            return;
        }
        this.savings += amount;
        System.out.println("deposit(" + (int) amount + ") -> savings = " + (int) this.savings);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal rejected: amount must be greater than 0");
            return;
        }
        if (amount > this.savings) {
            System.out.println("withdraw(" + (int) amount + ") -> rejected, savings stays " + (int) this.savings);
            return;
        }
        this.savings -= amount;
        System.out.println("withdraw(" + (int) amount + ") -> savings = " + (int) this.savings);
    }
}

class PiggyBankDemo {

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");

        pb.deposit(100);
        pb.withdraw(30);
        pb.withdraw(500);
    }
}
