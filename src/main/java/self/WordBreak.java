package self;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * You may assume the dictionary does not contain duplicate words.
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null) {
            return false;
        }
        int n = s.length();
        boolean[] breakable = new boolean[n + 1];
        breakable[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (breakable[j] && wordDict.contains(s.substring(j, i))) {
                    breakable[i] = true;
                    break;
                }
            }
        }
        return breakable[n];
    }

    public static void main(String[] args){
        WordBreak instance = new WordBreak();
        List<String> dict = new ArrayList<String>() {{
            add("leet");
            add("code");
        }};
        System.out.println(instance.wordBreak("leetcode", dict));

    }
}
