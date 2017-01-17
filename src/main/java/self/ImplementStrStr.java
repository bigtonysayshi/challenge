package self;

/**
 * Implement strStr().
 * Returns the index of the first occurrence of needle in haystack,
 * or -1 if needle is not part of haystack.
 */
public class ImplementStrStr {
    // Time: O(n*k) Space: O(1)
    public int strStr(String haystack, String needle) {
        int nl = needle.length();
        if (nl == 0) return 0;
        for (int i = 0; i + nl <= haystack.length(); i++) {
            for (int j = 0; j < nl; j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    break;
                } else if (j == nl - 1) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args){
        ImplementStrStr instance = new ImplementStrStr();
        System.out.println(instance.strStr("internationalization", "int"));
        System.out.println(instance.strStr("internationalization", "tern"));
        System.out.println(instance.strStr("internationalization", "inttttt"));
        System.out.println(instance.strStr("", "int"));
    }
}
