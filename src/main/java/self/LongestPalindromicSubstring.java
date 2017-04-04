package self;

/**
 * Given a string s, find the longest palindromic substring in s.
 * You may assume that the maximum length of s is 1000.
 */
public class LongestPalindromicSubstring {
    // Time: O(n^2) Space: O(n)
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String oddSub = findLongest(s, result, i, i);
            String evenSub = findLongest(s, result, i, i+1);
            if (oddSub.length() > result.length()) {
                result = oddSub;
            }
            if (evenSub.length() > result.length()) {
                result = evenSub;
            }
        }
        return result;
    }

    private String findLongest(String s, String current, int start, int end) {
        while (start >= 0 && end < s.length()) {
            if (s.charAt(start) != s.charAt(end)) {
                break;
            }
            if (end - start + 1 > current.length()) {
                current = s.substring(start, end + 1);
            }
            start--;
            end++;
        }
        return current;
    }

    public static void main(String[] args){
        LongestPalindromicSubstring instance = new LongestPalindromicSubstring();
        System.out.println(instance.longestPalindrome("babad"));
        System.out.println(instance.longestPalindrome("cbbd"));
        System.out.println(instance.longestPalindrome("abcdzdcab"));
        System.out.println(instance.longestPalindrome("ccc"));
        System.out.println(instance.longestPalindrome("cccc"));
        System.out.println(instance.longestPalindrome("bananas"));
    }
}
