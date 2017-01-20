package self;

import java.util.*;

/**
 * Given a string, sort it in decreasing order based on the frequency of characters.
 */
public class SortCharactersByFrequency {
    // Time: O(n) Space: O(1)
    public String frequencySort(String s) {
        Map<Character, Integer> charFreq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
        }
        List<Map.Entry<Character, Integer>> mapEntryList = new LinkedList<>(charFreq.entrySet());
        Collections.sort(mapEntryList,
                (Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2)
        -> e2.getValue().compareTo(e1.getValue()));
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : mapEntryList) {
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        SortCharactersByFrequency instance = new SortCharactersByFrequency();
        System.out.println(instance.frequencySort(""));
        System.out.println(instance.frequencySort("e"));
        System.out.println(instance.frequencySort("tree"));
        System.out.println(instance.frequencySort("acacaca"));
    }
}
