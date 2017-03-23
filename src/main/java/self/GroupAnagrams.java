package self;

import java.util.*;

/**
 * Given an array of strings, group anagrams together.
 * Note: All inputs will be in lower-case.
 */
public class GroupAnagrams {
    // Time: O(n*slogs) Space: O(n*s)
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key  = String.valueOf(chars);
            if (!groups.containsKey(key)) {
                groups.put(key, new ArrayList<>());
            }
            groups.get(key).add(s);
        }
        return new ArrayList<>(groups.values());
    }

    public static void main(String[] args){
        GroupAnagrams instance = new GroupAnagrams();
        System.out.println(instance.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
