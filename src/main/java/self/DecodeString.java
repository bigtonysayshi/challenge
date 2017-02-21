package self;

/**
 * Given an encoded string, return it's decoded string.
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is
 * being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * You may assume that the input string is always valid;
 * No extra white spaces, square brackets are well-formed, etc.
 * Furthermore, you may assume that the original data does not contain any digits
 * and that digits are only for those repeat numbers, k.
 * For example, there won't be input like 3a or 2[4].
 */
public class DecodeString {
    public String decodeString(String s) {
        int numStart = -1, openBracket = -1, closeBracket = -1, extraOpens = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                if (numStart < 0) {
                    numStart = i;
                }
            } else if (c == '[') {
                if (openBracket < 0) {
                    openBracket = i;
                } else {
                    extraOpens++;
                }
            } else if (c == ']') {
                if (extraOpens == 0) {
                    closeBracket = i;
                    int repeat = Integer.valueOf(s.substring(numStart, openBracket));
                    String sub = decodeString(s.substring(openBracket+1, closeBracket));
                    for (int j = 0; j < repeat; j++) {
                        sb.append(sub);
                    }
                    sb.append(decodeString(s.substring(closeBracket+1)));
                    return sb.toString();
                } else {
                    extraOpens--;
                }
            } else if (numStart < 0) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        DecodeString instance = new DecodeString();
        System.out.println(instance.decodeString("3[a]2[bc]"));
        System.out.println(instance.decodeString("3[a2[c]]"));
        System.out.println(instance.decodeString("2[abc]3[cd]ef"));
    }
}
