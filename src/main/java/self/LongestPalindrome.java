package self;

/**
 * Given a string which consists of lowercase or uppercase letters,
 * find the length of the longest palindromes that can be built with those letters.
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * Assume the length of given string will not exceed 1,010.
 */
public class LongestPalindrome {
    // Time: O(n) Space:O(1)
    public int longestPalindrome(String s) {
        int[] charCounts = new int[128];
        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'A']++;
        }
        int palindromeLength = 0;
        boolean hasSingle = false;
        for (int n : charCounts) {
            if (n > 0) {
                if (n % 2 == 0) {
                    palindromeLength += n;
                } else {
                    palindromeLength += n - 1;
                    hasSingle = true;
                }
            }
        }
        if (hasSingle) palindromeLength++;
        return palindromeLength;
    }

    public static void main(String[] args){
        LongestPalindrome instance = new LongestPalindrome();
        System.out.println(instance.longestPalindrome("abccccdd"));
        System.out.println(instance.longestPalindrome("AAAaAA"));
    }
}
