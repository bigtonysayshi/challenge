package self;

/**
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2.
 * (each operation is counted as 1 step.)
 * You have the following 3 operations permitted on a word:
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 */
public class EditDistance {
    // Time: O(mn) Space: O(n)
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return -1;
        }
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[2][n + 1];
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            dp[i % 2][0] = i;
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i % 2][j] = dp[(i - 1) % 2][j - 1];
                } else {
                    dp[i % 2][j] = Math.min(Math.min(dp[i % 2][j - 1],
                            dp[(i - 1) % 2][j]), dp[(i - 1) % 2][j - 1]) + 1;
                }
            }
        }
        return dp[m % 2][n];
    }

    public static void main(String[] args){
        EditDistance instance = new EditDistance();
        System.out.println(instance.minDistance("mart", "karma"));
        System.out.println(instance.minDistance("mart", ""));
        System.out.println(instance.minDistance("", "karma"));
        System.out.println(instance.minDistance("ab", "bc"));

    }
}
