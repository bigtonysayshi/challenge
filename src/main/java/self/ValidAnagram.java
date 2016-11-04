package self;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * You may assume the string contains only lowercase alphabets.
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class ValidAnagram {
    // n = chars in max(s,t). Time: O(n) Space: O(1)
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> charCounts = new HashMap<Character, Integer>();
        for (char c : s.toCharArray()) {
            if (charCounts.containsKey(c)) {
                charCounts.put(c, charCounts.get(c) + 1);
            } else {
                charCounts.put(c, 1);
            }
        }

        for (char c : t.toCharArray()) {
            if (!charCounts.containsKey(c)) {
                return false;
            } else {
                int count = charCounts.get(c);
                if (count <= 0) {
                    return false;
                }
                charCounts.put(c, count - 1);
            }
        }

        for (int count : charCounts.values()) {
            if (count > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        ValidAnagram instance = new ValidAnagram();
        System.out.println(instance.isAnagram("anagram", "nagaram"));
        System.out.println(instance.isAnagram("rat", "car"));
        System.out.println(instance.isAnagram("anagram-", "nagara-m"));
    }
}
