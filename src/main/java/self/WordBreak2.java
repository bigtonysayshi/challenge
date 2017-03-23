package self;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * add spaces in s to construct a sentence where each word is a valid dictionary word.
 * You may assume the dictionary does not contain duplicate words.

 Return all such possible sentences.
 */
public class WordBreak2 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, new HashMap<>());
    }

    private List<String> dfs(
                     String input,
                     List<String> dict,
                     Map<String, List<String>> explored) {
        if (explored.containsKey(input)) {
            return explored.get(input);
        }
        List<String> results = new ArrayList<>();
        if (input.length() == 0) {
            results.add("");
            return results;
        }
        for (String word : dict) {
            if (input.startsWith(word)) {
                List<String> subs = dfs(input.substring(word.length()), dict, explored);
                for (String sub : subs) {
                    results.add(word + (sub.length() == 0 ? "" : " ") + sub);
                }
            }
        }
        explored.put(input, results);
        return results;
    }

    public static void main(String[] args){
        WordBreak2 instance = new WordBreak2();
        List<String> dict = new ArrayList<String>() {{
            add("cat");
            add("cats");
            add("and");
            add("sand");
            add("dog");
        }};
        System.out.println(instance.wordBreak("catsanddog", dict));

    }
}
