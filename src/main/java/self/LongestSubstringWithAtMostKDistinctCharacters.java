package self;

/**
 * Given a string, find the length of the longest substring T that contains at most k distinct characters.
 */
public class LongestSubstringWithAtMostKDistinctCharacters {
    // Time: O(n) Space: O(1)
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || k <= 0) {
            return 0;
        }
        int[] charCounts = new int[256];
        int distinctChars = 0;
        int maxLen = 0;

        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length() && !(distinctChars == k && charCounts[s.charAt(j)] == 0) ) {
                char right = s.charAt(j);
                if (++charCounts[right] == 1) {
                    distinctChars++;
                }
                maxLen = Math.max(maxLen, j - i + 1);
                j++;
            }
            char left = s.charAt(i);
            if (--charCounts[left] == 0) {
                distinctChars--;
            }
        }
        return maxLen;
    }

    public static void main(String[] args){
        LongestSubstringWithAtMostKDistinctCharacters instance = new LongestSubstringWithAtMostKDistinctCharacters();
        System.out.println(instance.lengthOfLongestSubstringKDistinct("eceba", 2));
        System.out.println(instance.lengthOfLongestSubstringKDistinct("eceba", 3));
    }
}
