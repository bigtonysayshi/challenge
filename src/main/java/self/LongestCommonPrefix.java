package self;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String shortest = strs[0];
        for (String s : strs) {
            if (s.length() < shortest.length()) shortest = s;
        }
        int shortestOverlapLen = shortest.length();
        for (String s : strs) {
            int prefixLen = 0;
            for (int i = 0; i < shortest.length(); i++) {
                if (shortest.charAt(i) == s.charAt(i)) {
                    prefixLen++;
                } else {
                    break;
                }
            }
            shortestOverlapLen = Math.min(shortestOverlapLen, prefixLen);
        }
        return shortest.substring(0, shortestOverlapLen);
    }

    public static void main(String[] args){
        LongestCommonPrefix instance = new LongestCommonPrefix();
        System.out.println(instance.longestCommonPrefix(new String[]{"a"}));
        System.out.println(instance.longestCommonPrefix(new String[]{"a", "ab"}));
        System.out.println(instance.longestCommonPrefix(new String[]{"ab","bc"}));
        System.out.println(instance.longestCommonPrefix(new String[]{"aca","cba"}));

    }
}
