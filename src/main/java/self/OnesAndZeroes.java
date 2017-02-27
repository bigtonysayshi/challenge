package self;

/**
 * In the computer world, use restricted resource you have to generate maximum benefit is what we always want to pursue.
 * For now, suppose you are a dominator of m 0s and n 1s respectively. On the other hand,
 * there is an array with strings consisting of only 0s and 1s.
 * Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s.
 * Each 0 and 1 can be used at most once.
 * Note:
 * The given numbers of 0s and 1s will both not exceed 100
 * The size of given string array won't exceed 600
 */
public class OnesAndZeroes {
    // Time: O(mn) Space: O(mn)
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] counts = new int[m+1][n+1];
        for (String s : strs) {
            int zeroes = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') zeroes++;
            }
            int ones = s.length() - zeroes;
            for (int i = m; i >= zeroes; i--) {
                for (int j = n; j >= ones; j--) {
                    counts[i][j] = Math.max(counts[i][j], counts[i-zeroes][j-ones] + 1);
                }
            }
        }
        return counts[m][n];
    }


    public static void main(String[] args){
        OnesAndZeroes instance = new OnesAndZeroes();
        System.out.println(instance.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
        System.out.println(instance.findMaxForm(new String[]{"10", "0", "1"}, 1, 1));
    }
}
