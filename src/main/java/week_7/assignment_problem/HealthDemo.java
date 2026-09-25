package main.java.week_7.assignment_problem;
class HealthBarDemo {

    public static class Character {
        private final int maxHealth;
        private int currentHealth;

        public Character(int maxHealth) {
            this.maxHealth = Math.max(0, maxHealth);
            this.currentHealth = this.maxHealth;
        }

        public int getMaxHealth() {
            return this.maxHealth;
        }

        public int getCurrentHealth() {
            return this.currentHealth;
        }

        public void takeDamage(int amount) {
            if (amount <= 0) {
                return;
            }
            this.currentHealth = Math.max(0, this.currentHealth - amount);
            System.out.println("takeDamage(" + amount + ") -> health = " + this.currentHealth + (this.currentHealth == 0 ? " (floored)" : ""));
        }

        public void heal(int amount) {
            if (amount <= 0) {
                return;
            }
            this.currentHealth = Math.min(this.maxHealth, this.currentHealth + amount);
            System.out.println("heal(" + amount + ") -> health = " + this.currentHealth + (this.currentHealth == this.maxHealth ? " (capped)" : ""));
        }
    }

    public static void main(String[] args) {
        Character c = new Character(100);
        c.takeDamage(30);
        c.heal(50);
        c.takeDamage(150);
    }
}
