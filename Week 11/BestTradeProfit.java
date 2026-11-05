public class BestTradeProfit {

    public static int maxProfit(int[] prices) {
        int minPriceSoFar = Integer.MAX_VALUE;
        int bestProfit = 0;

        for (int price : prices) {
            if (price < minPriceSoFar) {
                minPriceSoFar = price;
            } else {
                bestProfit = Math.max(bestProfit, price - minPriceSoFar);
            }
        }

        return bestProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4})); // 5
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));    // 0
    }
}
