package self;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit.
 * You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
 * However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTimeToBuyAndSellStock2 {
    // Time: O(n) Space: O(1)
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int profit = 0, buyIdx = 0, sellIdx = -1;
        for (int i = 1; i < prices.length; i++) {
            int p = prices[i];
            if (sellIdx >= 0 && p >= prices[sellIdx]) {
                sellIdx++;
            } else if (p >= prices[buyIdx]) {
                if (sellIdx == -1) {
                    sellIdx = i;
                } else {
                    profit += prices[sellIdx] - prices[buyIdx];
                    buyIdx = i;
                    sellIdx = -1;
                }
            } else {
                if (sellIdx >= 0) {
                    profit += prices[sellIdx] - prices[buyIdx];
                    sellIdx = -1;
                }
                buyIdx = i;
            }
        }
        if (sellIdx >= 0) profit += prices[sellIdx] - prices[buyIdx];
        return profit;
    }

    // very simple greedy solution
    public int maxProfit2(int[] prices) {
        int total = 0;
        for (int i=0; i< prices.length-1; i++) {
            if (prices[i+1]>prices[i]) total += prices[i+1]-prices[i];
        }

        return total;
    }

    public static void main(String[] args){
        BestTimeToBuyAndSellStock2 instance = new BestTimeToBuyAndSellStock2();
        System.out.println(instance.maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
        System.out.println(instance.maxProfit(new int[] {7, 6, 4, 3, 1}));
        System.out.println(instance.maxProfit(new int[] {2, 1, 4}));
    }
}
