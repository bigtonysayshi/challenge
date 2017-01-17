package self;

/**
 * Implement atoi to convert a string to an integer.
 */
public class StringToInteger {
    public int myAtoi(String str) {
        if (str == null) return 0;
        // skip whitespaces
        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        if (i == str.length()) return 0;
        // skip plus/minus signs
        boolean negative = false;
        char start = str.charAt(i);
        if (start == '-') {
            negative = true;
            i++;
        } else if (start == '+') {
            i++;
        } else if (!Character.isDigit(start)) {
            return 0;
        }
        // skip 0s at head
        while (i < str.length() && str.charAt(i) == '0') {
            i++;
        }
        if (i == str.length()) return 0;
        int startIdx = i;
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            i++;
        }
        String actualNum = str.substring(startIdx, i);
        if (actualNum.isEmpty()) return 0;
        String maxIntStr = Integer.toString(Integer.MAX_VALUE);
        if (actualNum.length() > maxIntStr.length() ||
                (actualNum.length() == maxIntStr.length() && actualNum.compareTo(maxIntStr) > 0)) {
            return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        return Integer.valueOf(actualNum) * (negative ? -1 : 1);
    }

    public static void main(String[] args){
        StringToInteger instance = new StringToInteger();
        System.out.println(instance.myAtoi("  +1"));
        System.out.println(instance.myAtoi("  -0"));
        System.out.println(instance.myAtoi("  -18.3231.dajsi "));
        System.out.println(instance.myAtoi("  29.31.32 "));
        System.out.println(instance.myAtoi("  +00 "));

    }
}
