package self;

/**
 * Given a non-empty string s and an abbreviation abbr,
 * return whether the string matches with the given abbreviation.
 * Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.
 */
public class ValidWordAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < abbr.length(); i++) {
            char c = abbr.charAt(i);
            if (Character.isDigit(c)) {
                if (c == '0' && sb.toString().isEmpty()) return false;
                sb.append(c);
            } else {
                if (!sb.toString().isEmpty()) {
                    idx += Integer.valueOf(sb.toString());
                    sb = new StringBuilder();
                    if (idx >= word.length()) return false;
                }
                if (word.charAt(idx++) != c) return false;
            }
        }
        String rem = sb.toString();
        if (!rem.isEmpty()) idx += Integer.valueOf(rem);
        return idx == word.length();
    }

    public static void main(String[] args){
        ValidWordAbbreviation instance = new ValidWordAbbreviation();
        System.out.println(instance.validWordAbbreviation("internationalization", "i12iz4n"));
        System.out.println(instance.validWordAbbreviation("apple", "a2e"));
        System.out.println(instance.validWordAbbreviation("a", "2"));
        System.out.println(instance.validWordAbbreviation("a", "1"));
        System.out.println(instance.validWordAbbreviation("aa", "a1"));
        System.out.println(instance.validWordAbbreviation("internationalization", "i5a11o1"));
    }
}
