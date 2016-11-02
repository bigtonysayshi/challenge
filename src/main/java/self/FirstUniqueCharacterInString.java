package self;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the first non-repeating character in it and return it's index.
 * If it doesn't exist, return -1.
 * You may assume the string contain only lowercase letters.
 */
public class FirstUniqueCharacterInString {
    // Time: O(n) Space: O(1)
    public int firstUniqChar(String s) {
        int n = s.length();
        Map<Character, Integer> charIdxMap = new HashMap<Character, Integer>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            charIdxMap.put(c, charIdxMap.containsKey(c) ? n : i);
        }
        int minIdx = n;
        for (int idx : charIdxMap.values()) {
            if (idx < minIdx) {
                minIdx = idx;
            }
        }
        return minIdx == n ? -1 : minIdx;
    }

    // Time: O(n) Space: O(1)
    public int firstUniqChar2(String s) {
        int[] charFreq = new int[26];
        for (char c : s.toCharArray()) {
            charFreq[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (charFreq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        FirstUniqueCharacterInString instance = new FirstUniqueCharacterInString();
        System.out.println(instance.firstUniqChar("leetcode"));
        System.out.println(instance.firstUniqChar("loveleetcode"));
        System.out.println(instance.firstUniqChar("eettcc"));
    }
}
