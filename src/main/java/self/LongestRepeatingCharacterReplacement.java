package self;

/**
 * Given a string that consists of only uppercase English letters,
 * you can replace any letter in the string with another letter at most k times.
 * Find the length of a longest substring containing all repeating letters you can get after performing the above operations.
 * Note: Both the string's length and k will not exceed 10^4.
 */
public class LongestRepeatingCharacterReplacement {
    // Time: O(n) Space: O(1)
    public int characterReplacement(String s, int k) {
        int n = s.length(), maxCount = 0, maxLen = 0, start = 0, end = 0;
        int[] counts = new int[26];
        for (;end < n; end++) {
            maxCount = Math.max(maxCount, ++counts[s.charAt(end) - 'A']);
            while (end - start + 1 - maxCount > k) {
                counts[s.charAt(start++) - 'A']--;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }

    public static void main(String[] args){
        LongestRepeatingCharacterReplacement instance = new LongestRepeatingCharacterReplacement();
        System.out.println(instance.characterReplacement("ABAB",2));
        System.out.println(instance.characterReplacement("ABBB",2));
        System.out.println(instance.characterReplacement("AABABBA",1));
    }
}
