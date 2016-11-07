package self;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction
 * (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 */
public class BestTimeToBuyAndSellStock {
    // Time: O(n) Space: O(1)
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int currentBuy = prices[0];
        int currentProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            if (price - currentBuy > currentProfit) {
                currentProfit = price - currentBuy;
            } else if (price < currentBuy) {
                currentBuy = price;
            }
        }
        return currentProfit;
    }

    public static void main(String[] args){
        BestTimeToBuyAndSellStock instance = new BestTimeToBuyAndSellStock();
        System.out.println(instance.maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
        System.out.println(instance.maxProfit(new int[] {7, 6, 4, 3, 1}));
        System.out.println(instance.maxProfit(new int[] {2, 1, 4}));

    }
}
