package self;

import java.util.HashSet;
import java.util.Set;

/**
 * Consider the string s to be the infinite wraparound string of "abcdefghijklmnopqrstuvwxyz",
 * so s will look like this: "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".
 * Now we have another string p. Your job is to find out how many unique non-empty substrings of p are present in s.
 * In particular, your input is the string p and you need to output the number of different non-empty substrings of p in the string s.
 * Note: p consists of only lowercase English letters and the size of p might be over 10000.
 */
public class UniqueSubstringsInWraparoundString {
    // Time: O(n) Space: O(1)
    public int findSubstringInWraproundString(String p) {
        if (p == null || p.length() == 0) {
            return 0;
        }
        int n = p.length();

        // max number of unique substrings ending on each char
        int[] maxCounts = new int[26];
        int len = 0;
        for (int i = 0; i < n; i++) {
            char curr = p.charAt(i);
            if (i == 0 || (curr - p.charAt(i - 1) == 1) || (curr == 'a' && p.charAt(i - 1) == 'z')) {
                len++;
            } else {
                len = 1;
            }
            maxCounts[curr - 'a'] = Math.max(maxCounts[curr - 'a'], len);
        }
        int results = 0;
        for (int c : maxCounts) {
            results += c;
        }
        return results;
    }

    public static void main(String[] args){
        UniqueSubstringsInWraparoundString instance = new UniqueSubstringsInWraparoundString();
        System.out.println(instance.findSubstringInWraproundString("zab"));

    }
}
