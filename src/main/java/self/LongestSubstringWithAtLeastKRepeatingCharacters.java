package self;

import java.util.HashMap;

/**
 * Find the length of the longest substring T of a given string (consists of lowercase letters only)
 * such that every character in T appears no less than k times.
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {
    // Time: O(n) Space: O(n)
    public int longestSubstring(String s, int k) {
        HashMap<Character, Integer> charCounts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }
        int maxLen = 0, start = 0;
        while (start < s.length()) {
            HashMap<Character, Integer> tmpCharCounts = new HashMap<>();
            for (int end = start; end < s.length(); end++) {
                Character c = s.charAt(end);
                if (charCounts.get(c) < k) {
                    if (validateCharCounts(tmpCharCounts, k)) maxLen = Math.max(maxLen, end - start);
                    start++;
                    break;
                } else {
                    tmpCharCounts.put(c, tmpCharCounts.getOrDefault(c, 0) + 1);
                    if (validateCharCounts(tmpCharCounts, k)) maxLen = Math.max(maxLen, end - start + 1);
                }
                if (end == s.length() - 1) {
                    if (validateCharCounts(tmpCharCounts, k)) maxLen = Math.max(maxLen, s.length() - start);
                    return maxLen;
                }
            }
        }
        return maxLen;
    }

    private boolean validateCharCounts(HashMap<Character, Integer> charCounts, int k) {
        for (Integer count : charCounts.values()) {
            if (count < k) return false;
        }
        return true;
    }

    public static void main(String[] args){
        LongestSubstringWithAtLeastKRepeatingCharacters instance = new LongestSubstringWithAtLeastKRepeatingCharacters();
        System.out.println(instance.longestSubstring("aaabb", 3));
        System.out.println(instance.longestSubstring("ababbc", 2));
        System.out.println(instance.longestSubstring("ababacb", 3));
        System.out.println(instance.longestSubstring("aaabbb", 3));
        System.out.println(instance.longestSubstring("bbaaacbd", 3));
        System.out.println(instance.longestSubstring("baaabcb", 3));
    }
}
