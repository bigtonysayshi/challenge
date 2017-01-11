package self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a sequence of words, check whether it forms a valid word square.
 * A sequence of words forms a valid word square if the kth row and column read the exact same string,
 * where 0 ≤ k < max(numRows, numColumns).
 * Note:
 * The number of words given is at least 1 and does not exceed 500.
 * Word length will be at least 1 and does not exceed 500.
 * Each word contains only lowercase English alphabet a-z.
 */
public class ValidWordSquare {
    // Time: O(max(m,n)^2) Space: O(1)
    public boolean validWordSquare(List<String> words) {
        int numRows = words.size();
        int numCols = words.get(0).length();
        for (String w : words) {
            if (w.length() > numCols) numCols = w.length();
        }
        int bound = Math.max(numRows, numCols);
        if (bound > numRows) return false;
        for (int i = 0; i < bound; i++) {
            String row = words.get(i);
            for (int j = 0; j < bound; j++) {
                String w = words.get(j);
                if (j >= row.length()) {
                    if (w.length() > i) return false;
                } else if (w.length() <= i || w.charAt(i) != row.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        ValidWordSquare instance = new ValidWordSquare();
        List<String> input = new ArrayList<>(Arrays.asList(new String[]{"ball","asee","let","lep"}));
        System.out.println(instance.validWordSquare(input));
    }
}
