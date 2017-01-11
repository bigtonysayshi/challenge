package self;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * Strings consists of lowercase English letters only and the length of both strings s and p
 * will not be larger than 20,100.
 * The order of output does not matter.
 */
public class FindAllAnagramsInAString {
    // Time: O(n) Space: O(n)
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> results = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        if (s == null || sLen < pLen) return results;
        Map<Character, Integer> charCounts = new HashMap<>();
        for (int i = 0; i < pLen; i++) {
            Character key = p.charAt(i);
            Integer count = charCounts.get(key);
            charCounts.put(key, count == null ? 1 : count + 1);
        }
        for (int i = 0; i < pLen; i++) {
            Character key = s.charAt(i);
            if (charCounts.containsKey(key)) {
                charCounts.put(key, charCounts.get(key) - 1);
            }
        }
        int distance = 0;
        for (Integer diff : charCounts.values()) {
            distance += Math.abs(diff);
        }
        if (distance == 0) results.add(0);

        for (int i = 1; i + pLen <= sLen; i++) {
            char left = s.charAt(i - 1);
            char right = s.charAt(i + pLen - 1);
            if (charCounts.containsKey(left)) {
                int leftCount = charCounts.get(left);
                if (leftCount >= 0) {
                    distance++;
                } else {
                    distance--;
                }
                charCounts.put(left, leftCount + 1);
            }
            if (charCounts.containsKey(right)) {
                int rightCount = charCounts.get(right);
                if (rightCount <= 0) {
                    distance++;
                } else {
                    distance--;
                }
                charCounts.put(right, rightCount - 1);
            }
            if (distance == 0) results.add(i);
        }
        return results;
    }

    // Nice sliding window template
    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
        int[] hash = new int[256]; //character hash
        //record each character in p to hash
        for (char c : p.toCharArray()) {
            hash[c]++;
        }
        //two points, initialize count to p's length
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            //move right everytime, if the character exists in p's hash, decrease the count
            //current hash value >= 1 means the character is existing in p
            if (hash[s.charAt(right++)]-- >= 1) count--;

            //when the count is down to 0, means we found the right anagram
            //then add window's left to result list
            if (count == 0) list.add(left);

            //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
            //++ to reset the hash because we kicked out the left
            //only increase the count if the character is in p
            //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
            if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
        }
        return list;
    }

    public static void main(String[] args){
        FindAllAnagramsInAString instance = new FindAllAnagramsInAString();
        System.out.println(instance.findAnagrams("cbaebabacd", "abc"));
        System.out.println(instance.findAnagrams("abab", "ab"));
        System.out.println(instance.findAnagrams("bpaa", "aa"));
    }
}
