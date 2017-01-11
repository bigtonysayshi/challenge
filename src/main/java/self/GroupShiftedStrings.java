package self;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given a string, we can "shift" each of its letter to its successive letter,
 * for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
 * "abc" -> "bcd" -> ... -> "xyz"
 * Given a list of strings which contains only lowercase alphabets,
 * group all strings that belong to the same shifting sequence.
 */
public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> shiftMap = new HashMap<>();
        for (String s : strings) {
            int offset = s.charAt(0) - 'a';
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) - offset < 'a') {
                    sb.append(s.charAt(i) - offset + 26);
                } else {
                    sb.append(s.charAt(i) - offset);
                }
            }
            String originalForm = sb.toString();
            if (shiftMap.containsKey(originalForm)) {
                shiftMap.get(originalForm).add(s);
            } else {
                List<String> l = new ArrayList<>();
                l.add(s);
                shiftMap.put(originalForm, l);
            }
        }
        List<List<String>> results = new ArrayList<>();
        results.addAll(shiftMap.values());
        return results;
    }

    public static void main(String[] args){
        GroupShiftedStrings instance = new GroupShiftedStrings();
        System.out.println(instance.groupStrings(
                new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"}));
    }
}
