package self;

import java.util.*;

/**
 * This is a follow up of Shortest Word Distance. The only difference is now you are given the list
 * of words and your method will be called repeatedly many times with different parameters.
 * How would you optimize it?
 * Design a class which receives a list of words in the constructor,
 * and implements a method that takes two words word1 and word2 and
 * return the shortest distance between these two words in the list.
 * Note
 * You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */
public class ShortestWordDistance2 {
    Map<String, List<Integer>> indexMap = new HashMap<>();

    public ShortestWordDistance2(String[] words) {
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            if (!indexMap.containsKey(s)) indexMap.put(s, new ArrayList<>());
            indexMap.get(s).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> l1 = indexMap.get(word1);
        List<Integer> l2 = indexMap.get(word2);
        int d = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < l1.size() && j < l2.size();) {
            int idx1 = l1.get(i), idx2 = l2.get(j);
            d = Math.min(d, Math.abs(idx1 - idx2));
            if (idx1 < idx2) {
                i++;
            } else {
                j++;
            }
        }
        return d;
    }
}
