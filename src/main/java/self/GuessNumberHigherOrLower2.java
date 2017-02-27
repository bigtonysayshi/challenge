package self;

import java.util.Arrays;

/**
 * We are playing the Guess Game. The game is as follows:
 * I pick a number from 1 to n. You have to guess which number I picked.
 * Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.
 * However, when you guess a particular number x, and you guess wrong, you pay $x.
 * You win the game when you guess the number I picked.
 * Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
 */
public class GuessNumberHigherOrLower2 {
    // TimeL O(n^3) Space: O(n^2)
    public int getMoneyAmount(int n) {
        int[][] costs = new int[n+1][n+1];
        for (int len = 2; len <=n; len++) {
            for (int start = 1; start <= n - len + 1; start++) {
                int minCost = Integer.MAX_VALUE;
                for (int pivot = start; pivot < start + len - 1; pivot++) {
                    int cost = pivot + Math.max(costs[start][pivot-1], costs[pivot+1][start+len-1]);
                    minCost = Math.min(minCost, cost);
                }
                costs[start][start+len-1] = minCost;
            }
        }
        return costs[1][n];
    }

    public static void main(String[] args){
        GuessNumberHigherOrLower2 instance = new GuessNumberHigherOrLower2();
        System.out.println(instance.getMoneyAmount(1));
        System.out.println(instance.getMoneyAmount(2));
        System.out.println(instance.getMoneyAmount(3));
        System.out.println(instance.getMoneyAmount(4));
        System.out.println(instance.getMoneyAmount(5));
    }
}
