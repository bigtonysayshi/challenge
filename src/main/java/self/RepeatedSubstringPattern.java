package self;

/**
 * Given a non-empty string check if it can be constructed by taking a substring of it
 * and appending multiple copies of the substring together.
 * You may assume the given string consists of lowercase English letters only
 * and its length will not exceed 10000.
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String str) {
        int len = str.length();
        for (int l = 1; l <= len / 2; l++) {
            if (len % l == 0) {
                int quant = len / l;
                String base = str.substring(0, l);
                boolean match = true;
                for (int i = 1; i < quant; i++) {
                    String sub = str.substring(l * i, l * (i + 1));
                    if (!sub.equals(base)) match = false;
                }
                if (match) return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        RepeatedSubstringPattern instance = new RepeatedSubstringPattern();
        System.out.println(instance.repeatedSubstringPattern("abab"));
        System.out.println(instance.repeatedSubstringPattern("aba"));
        System.out.println(instance.repeatedSubstringPattern("abcabcabc"));
    }
}
