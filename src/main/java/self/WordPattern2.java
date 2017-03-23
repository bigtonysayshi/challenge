package self;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.
 * Notes: You may assume both pattern and str contains only lowercase letters.
 */
public class WordPattern2 {
    public boolean wordPatternMatch(String pattern, String str) {
        if (pattern == null || str == null) {
            return false;
        }
        return match(str, pattern, 0, 0, new HashMap<>());
    }

    private boolean match(String str, String pattern, int sIdx, int pIdx, Map<Character, String> patternMap) {
        if (sIdx == str.length() && pIdx == pattern.length()) {
            return true;
        }
        if (sIdx == str.length() || pIdx == pattern.length()) {
            return false;
        }
        Character c = pattern.charAt(pIdx);
        if (patternMap.containsKey(c)) {
            String sub = patternMap.get(c);
            if (str.startsWith(sub, sIdx)) {
                return match(str, pattern, sIdx + sub.length(), pIdx + 1, patternMap);
            } else {
                return false;
            }
        }
        for (int i = sIdx; i < str.length(); i++) {
            String sub = str.substring(sIdx, i + 1);
            if (patternMap.containsValue(sub)) {
                continue;
            }
            patternMap.put(c, sub);
            if (match(str, pattern, i + 1, pIdx + 1, patternMap)) {
                return true;
            }
            patternMap.remove(c);
        }
        return false;
    }

    public static void main(String[] args){
        WordPattern2 instance = new WordPattern2();
        System.out.println(instance.wordPatternMatch("abab", "redblueredblue"));
        System.out.println(instance.wordPatternMatch("aaaa", "asdasdasdasd"));
        System.out.println(instance.wordPatternMatch("aabb", "xyzabcxzyabc"));

    }
}
