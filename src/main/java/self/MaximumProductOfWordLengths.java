package self;

import java.util.Collections;
import java.util.HashSet;

/**
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j])
 * where the two words do not share common letters.
 * You may assume that each word will contain only lower case letters.
 * If no such two words exist, return 0.
 */
public class MaximumProductOfWordLengths {
    // Time: O(n^2) Space: O(n)
    public int maxProduct(String[] words) {
        int n = words.length;
        if (n <= 1) return 0;
        int[] bitMap = new int[n];
        for (int i = 0; i < n; i++) {
            String w = words[i];
            int bits = 0;
            for (int j = 0; j < w.length(); j++) {
                bits |= (1 << (w.charAt(j) - 'a'));
            }
            bitMap[i] = bits;
        }
        int maxProduct = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((bitMap[i] & bitMap[j]) == 0) {
                    maxProduct = Math.max(maxProduct, words[i].length() * words[j].length());
                }
            }
        }
        return maxProduct;
    }

    public static void main(String[] args){
        MaximumProductOfWordLengths instance = new MaximumProductOfWordLengths();
        System.out.println(instance.maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));
        System.out.println(instance.maxProduct(new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"}));
        System.out.println(instance.maxProduct(new String[]{"a", "aa", "aaa", "aaaa"}));
    }
}
