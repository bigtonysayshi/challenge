package self;

/**
 * Implement regular expression matching with support for '.' and '*'.
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 */
public class RegularExpressionMatching {
    // Time: O(mn) Space: O(mn)
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char c2 = p.charAt(j - 1);
                if (c2 == '*') {
                    if (dp[i][j - 2]) {
                        dp[i][j] = true;
                        if (i < m && (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i))) {
                            dp[i + 1][j] = true;
                        }
                    } else if (i > 1 && dp[i - 1][j] &&
                            (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1))) {
                        dp[i][j] = true;
                    }

                } else if (i > 0 && j > 0 && (c2 == '.' || c2 == s.charAt(i - 1))) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args){
        RegularExpressionMatching instance = new RegularExpressionMatching();
        System.out.println(instance.isMatch("aaa","aa"));
        System.out.println(instance.isMatch("aaa","a.a"));
        System.out.println(instance.isMatch("aaa","a*"));
        System.out.println(instance.isMatch("aaa","a*a"));
        System.out.println(instance.isMatch("aaa",".*"));
        System.out.println(instance.isMatch("aaab","c*a*b*"));
        System.out.println(instance.isMatch("aaab",".*"));
        System.out.println(instance.isMatch("aaa","ab*a"));
        System.out.println(instance.isMatch("aaba","ab*a*c*a"));

    }
}
