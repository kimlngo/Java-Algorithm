package algo;

public class BuySellStocks {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minSoFar = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price < minSoFar) {
                minSoFar = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minSoFar);
            }
        }

        return maxProfit;
    }
}
