package main.java.week_4.class_problem;
class StockTrader {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                int currentProfit = price - minPrice;
                maxProfit = Math.max(maxProfit, currentProfit);
            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Output: " + maxProfit(prices1));
    }
}
