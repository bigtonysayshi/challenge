package self;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    // Time: O(n) Space: O(n)
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int j = 0;
        int longest = 0;
        Set<Character> currentChars = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            j = Math.max(j, i);
            while (j < s.length() && !currentChars.contains(s.charAt(j))) {
                currentChars.add(s.charAt(j++));
            }
            longest = Math.max(longest, j - i);
            currentChars.remove(s.charAt(i));
        }
        return longest;
    }

    public static void main(String[] args){
        LongestSubstringWithoutRepeatingCharacters instance = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(instance.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(instance.lengthOfLongestSubstring("bbbbb"));
        System.out.println(instance.lengthOfLongestSubstring("pwwkew"));
    }
}
