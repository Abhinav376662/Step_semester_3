public class L2BestTimeToBuySellStock {

    static int maxProfit(int[] prices) {
        int lowestPrice = prices[0];
        int maximumProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int currentProfit = prices[i] - lowestPrice;

            if (currentProfit > maximumProfit) {
                maximumProfit = currentProfit;
            }

            if (prices[i] < lowestPrice) {
                lowestPrice = prices[i];
            }
        }

        return maximumProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};

        System.out.println(maxProfit(prices));
    }
}
