package self;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 */
public class LetterCombinationsOfAPhoneNumber {
    private static char[][] DIGIT_CHAR_MAP = new char[][] {
            {' '},
            {},
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r','s'},
            {'t','u','v'},
            {'w','x','y','z'}
    };

    // Time: O(n) Space: O(n)
    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        addLetters(results, new StringBuilder(), digits, 0);
        return results;
    }

    private void addLetters(List<String> results, StringBuilder sb, String digits, int idx) {
        if (idx == digits.length()) {
            if (sb.length() > 0) results.add(sb.toString());
            return;
        }
        int d = Character.getNumericValue(digits.charAt(idx));
        for (char c : DIGIT_CHAR_MAP[d]) {
            sb.append(c);
            addLetters(results, sb, digits, idx+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args){
        LetterCombinationsOfAPhoneNumber instance = new LetterCombinationsOfAPhoneNumber();
        System.out.println(instance.letterCombinations("23"));
    }
}
