package self;

import java.util.HashMap;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the
 * order of characters. No two characters may map to the same character but a character may map to itself.
 * You may assume both s and t have the same length.
 */
public class IsomorphicStrings {
    // Time: O(n) Space: O(1)
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> dict = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (!dict.containsKey(sc)) {
                if (dict.containsValue(tc)) return false;
                dict.put(sc, tc);
            } else {
                if (!dict.get(sc).equals(tc)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        IsomorphicStrings instance = new IsomorphicStrings();
        System.out.println(instance.isIsomorphic("egg", "add"));
        System.out.println(instance.isIsomorphic("foo", "bar"));
        System.out.println(instance.isIsomorphic("ab", "aa"));
    }
}
