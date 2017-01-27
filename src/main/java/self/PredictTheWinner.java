package self;

/**
 * Given an array of scores that are non-negative integers.
 * Player 1 picks one of the numbers from either end of the array followed by the player 2 and then player 1 and so on.
 * Each time a player picks a number, that number will not be available for the next player.
 * This continues until all the scores have been chosen. The player with the maximum score wins.
 * Given an array of scores, predict whether player 1 is the winner.
 * You can assume each player plays to maximize his score.
 *
 * Note:
 * 1 <= length of the array <= 20.
 * Any scores in the given array are non-negative integers and will not exceed 10,000,000.
 * If the scores of both players are equal, then player 1 is still the winner.
 */
public class PredictTheWinner {
    // Time: O(n^2) Space: O(n^2)
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] scoreMap = new int[n][n];
        return maxScore(nums, 0, n - 1, scoreMap) >= 0;
    }

    private int maxScore(int[] nums, int start, int end, int[][] scoreMap) {
        if (scoreMap[start][end] == 0) {
            scoreMap[start][end] = start == end ? nums[start] :
                    Math.max(nums[start] - maxScore(nums, start + 1, end, scoreMap),
                            nums[end] - maxScore(nums, start, end - 1, scoreMap));
        }
        return scoreMap[start][end];
    }

    public static void main(String[] args){
        PredictTheWinner instance = new PredictTheWinner();
        System.out.println(instance.PredictTheWinner(new int[]{1,5,2}));
        System.out.println(instance.PredictTheWinner(new int[]{1,5,233,7}));
        System.out.println(instance.PredictTheWinner(new int[]{1,567,1,1,99,100}));
    }
}
