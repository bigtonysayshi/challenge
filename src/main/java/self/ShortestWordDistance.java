package self;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a list of words and two words word1 and word2,
 * return the shortest distance between these two words in the list.
 * You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */
public class ShortestWordDistance {
    // Time: O(n) Space:O(1)
    public int shortestDistance(String[] words, String word1, String word2) {
        int index1 = -1, index2 = -1, distance = words.length;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.equals(word1)) {
                index1 = i;
            } else if (word.equals(word2)) {
                index2 = i;
            }
            if (index1 >= 0 && index2 >= 0 && Math.abs(index1 - index2) < distance) {
                distance = Math.abs(index1 - index2);
            }
        }
        return distance;
    }

    public static void main(String[] args){
        ShortestWordDistance instance = new ShortestWordDistance();
        String[] words = new String[]{"practice", "makes", "perfect", "coding", "makes"};
        System.out.println(instance.shortestDistance(words, "practice", "coding"));
        System.out.println(instance.shortestDistance(words, "makes", "coding"));
    }
}
