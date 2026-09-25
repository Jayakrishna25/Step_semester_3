package main.java.week_7.assignment_problem;
class ShoppingCartDemo {

    public static class Cart {
        private final String cartId;
        private final double[] prices;
        private int count;

        public Cart(String cartId, int maxCapacity) {
            this.cartId = cartId;
            if (maxCapacity < 0) {
                this.prices = new double[0];
            } else {
                this.prices = new double[maxCapacity];
            }
            this.count = 0;
        }

        public String getCartId() {
            return this.cartId;
        }

        public void addItem(double price) {
            if (price < 0 || count >= prices.length) {
                return;
            }
            prices[count++] = price;
        }

        public double getTotal() {
            double sum = 0.0;
            for (int i = 0; i < count; i++) {
                sum += prices[i];
            }
            return sum;
        }

        public int getItemCount() {
            return this.count;
        }
    }

    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("cart.getTotal() -> " + (int) cart.getTotal());
        System.out.println("cart.getItemCount() -> " + cart.getItemCount());
    }
}