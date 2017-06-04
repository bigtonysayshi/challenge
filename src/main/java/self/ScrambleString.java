package self;

/**
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 */
public class ScrambleString {
    // Time: O(n^4) Space: O(n^3)
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        int n = s1.length();
        if (s2.length() != n) {
            return false;
        }
        if (n == 0) {
            return true;
        }
        boolean[][][] dp = new boolean[n][n][n+1];
        for (int k = 1; k <= n; k++) {
            for (int x = 0; x + k <= n; x++) {
                for (int y = 0; y + k <= n; y++) {
                    if (k == 1) {
                        dp[x][y][k] = s1.charAt(x) == s2.charAt(y);
                    } else {
                        boolean flag = false;
                        for (int i = 1; i < k; i++) {
                            if ((dp[x][y][i] && dp[x+i][y+i][k-i]) ||
                                    (dp[x][y+k-i][i] && dp[x+i][y][k-i])) {
                                flag = true;
                                break;
                            }
                        }
                        dp[x][y][k] = flag;
                    }
                }
            }
        }
        return dp[0][0][n];
    }

    public static void main(String[] args){
        ScrambleString instance = new ScrambleString();
        System.out.println(instance.isScramble("great", "rgtae"));
        System.out.println(instance.isScramble("great", "aregt"));

    }
}
