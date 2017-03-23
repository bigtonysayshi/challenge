package self;

import java.util.*;

/**
 * Created by tzhang2 on 3/19/17.
 */
public class LetterCombo2 {
    private static String[] KEY_MAP = new String[] {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    private static Set<String> DICT = new HashSet<String>() {{
        add("drop");
        add("box");
        add("cox");
        add("dropbox");
    }};

    // Time: O(n) Space: O(n)
    public List<String> letterCombinations(String digits) {
        Set<String> results = new HashSet<>();
        int[] keys = buildKeys(digits);

        addLetters(results, "", new StringBuilder(), keys, 0);
        return new ArrayList<>(results);
    }

    private int[] buildKeys(String digits) {
        int[] keys = new int[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            if (Character.isDigit(digits.charAt(i))) {
                keys[i] =  Character.getNumericValue(digits.charAt(i));
            }
        }
        return keys;
    }

    private void addLetters(Set<String> results, String combo, StringBuilder word, int[] keys, int idx) {
        if (idx == keys.length) {
            if (word.length() == 0) {
                results.add(combo);
            }
            return;
        }
        int key = keys[idx];
        for (char c : KEY_MAP[key].toCharArray()) {
            word.append(c);
            if (isWord(word.toString())) {
                addLetters(results, combo + word.toString(), new StringBuilder(), keys, idx + 1);
            }
            addLetters(results, combo, word, keys, idx + 1);
            word.deleteCharAt(word.length() - 1);
        }
    }

    private boolean isWord(String word) {
        return DICT.contains(word);
    }

    private boolean isPredix(String word) {
        return true;
    }
    public static void main(String[] args){
        LetterCombo2 instance = new LetterCombo2();
        System.out.println(instance.letterCombinations("3767269"));
        System.out.println(instance.letterCombinations("3767"));
        System.out.println(instance.letterCombinations("269"));
    }
}
