package self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Write a function to generate the generalized abbreviations of a word.
 */
public class GeneralizedAbbreviation {
    // Time: O(n*2^n) Space: O(2^n)
    public List<String> generateAbbreviations(String word) {
        List<String> abbreviations = new ArrayList<>();
        int n = word.length();
        for (int k = 0; k < Math.pow(2, n); k++) {
            int count = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if ((k & 1<<i) == 1<<i) {
                    if (count > 0) {
                        sb.append(count);
                        count = 0;
                    }
                    sb.append(word.charAt(i));
                } else {
                    count++;
                }
            }
            if (count > 0) {
                sb.append(count);
            }
            abbreviations.add(sb.toString());
        }
        return abbreviations;
    }

    public static void main(String[] args){
        GeneralizedAbbreviation instance = new GeneralizedAbbreviation();
        System.out.println(instance.generateAbbreviations("word"));
    }
}
