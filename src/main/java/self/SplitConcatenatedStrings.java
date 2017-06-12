package self;

/**
 * Given a list of strings, you could concatenate these strings together into a loop,
 * where for each string you could choose to reverse it or not. Among all the possible loops,
 * you need to find the lexicographically biggest string after cutting the loop,
 * which will make the looped string into a regular one.
 * Specifically, to find the lexicographically biggest string, you need to experience two phases:
 * Concatenate all the strings into a loop,
 * where you can reverse some strings or not and connect them in the same order as given.
 * Cut and make one breakpoint in any place of the loop,
 * which will make the looped string into a regular one starting from the character at the cutpoint.
 * And your job is to find the lexicographically biggest one among all the possible regular strings.
 *
 * Note:
 * The input strings will only contain lowercase letters.
 * The total length of all the strings will not over 1,000.
 */
public class SplitConcatenatedStrings {
    // Time: O(m^2) Space: O(m) where m is the total characters
    public String splitLoopedString(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int n = strs.length;
        for (int i = 0; i < n; i++) {
            String str = strs[i];
            String reverse = reverse(str);
            if (str.compareTo(reverse) < 0) {
                strs[i] = reverse;
            }
        }
        String result = "a";
        for (int i = 0; i < n; i++) {
            String str = strs[i];
            String reverse = reverse(str);
            for (String s : new String[]{str, reverse}) {
                for (int j = 0; j < s.length(); j++) {
                    StringBuilder sb = new StringBuilder();
                    for (int k = j; k < s.length(); k++) {
                        sb.append(s.charAt(k));
                    }
                    for (int ii = i + 1; ii < n; ii++) {
                        sb.append(strs[ii]);
                    }
                    for (int ii = 0; ii < i; ii++) {
                        sb.append(strs[ii]);
                    }
                    for (int k = 0; k < j; k++) {
                        sb.append(s.charAt(k));
                    }
                    if (sb.toString().compareTo(result) > 0) {
                        result = sb.toString();
                    }
                }
            }
        }
        return result;
    }

    private String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    public static void main(String[] args){
        SplitConcatenatedStrings instance = new SplitConcatenatedStrings();
        System.out.println(instance.splitLoopedString(new String[]{"abc", "xyz"}));
        System.out.println(instance.splitLoopedString(new String[]{"abc", "xyz", "bzz"}));

    }
}
