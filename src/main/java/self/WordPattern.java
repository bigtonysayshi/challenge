package self;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        ArrayList<String> validWords = new ArrayList<>();
        for (String w : words) {
            if (!w.isEmpty()) validWords.add(w);
        }
        if (validWords.size() != pattern.length()) return false;
        HashMap<Character, String> dict= new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            String word = validWords.get(i);
            String expectedWord = dict.get(pattern.charAt(i));
            if (expectedWord == null) {
                if (dict.containsValue(word)) return false;
                dict.put(pattern.charAt(i), word);
            } else if (!expectedWord.equals(word)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        WordPattern instance = new WordPattern();
        System.out.println(instance.wordPattern("abba", "dog cat cat dog"));
        System.out.println(instance.wordPattern("abba", "dog cat cat"));
        System.out.println(instance.wordPattern("a", " "));
        System.out.println(instance.wordPattern("a", ""));
        System.out.println(instance.wordPattern("", ""));
    }
}
