package self;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by tzhang2 on 1/15/17.
 */
public class UniqueWordAbbreviation {
    public static void main(String[] args) {
        String[] dict = new String[]{"deer", "door", "cake", "card"};
        ValidWordAbbr vwa = new ValidWordAbbr(dict);
        System.out.println(vwa.isUnique("dear"));
        System.out.println(vwa.isUnique("cart"));
        System.out.println(vwa.isUnique("cane"));
        System.out.println(vwa.isUnique("make"));
        System.out.println(vwa.isUnique("door"));
        System.out.println(vwa.isUnique("cake"));
    }

}


class ValidWordAbbr {
    Map<String, Set<String>> abbreviations = new HashMap<>();

    public ValidWordAbbr(String[] dictionary) {
        for (String s : dictionary) {
            String abbr = getAbbr(s);
            Set<String> words = abbreviations.get(abbr);
            if (words == null) {
                words = new HashSet<>();
            }
            words.add(s);
            abbreviations.put(abbr, words);
        }
    }

    public boolean isUnique(String word) {
        String abbr = getAbbr(word);
        Set<String> words = abbreviations.get(abbr);
        return words == null || (words.size() == 1 && words.contains(word));
    }

    private String getAbbr(String s) {
        return s.length() <= 2 ? s : s.substring(0,1) + (s.length() - 2) + s.charAt(s.length() - 1);
    }
}