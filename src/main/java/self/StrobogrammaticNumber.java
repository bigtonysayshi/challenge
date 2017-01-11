package self;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees
 * (looked at upside down).
 * Write a function to determine if a number is strobogrammatic.
 * The number is represented as a string.
 */
public class StrobogrammaticNumber {
    // Time: O(n) Space: O(1)
    public boolean isStrobogrammatic(String num) {
        int len = num.length();
        for (int i = 0; i < len; i++) {
            char c = num.charAt(i);
            switch (c) {
                case '0':
                    if (num.charAt(len - 1 - i) != '0') return false;
                    break;
                case '1':
                    if (num.charAt(len - 1 - i) != '1') return false;
                    break;
                case '6':
                    if (num.charAt(len - 1 - i) != '9') return false;
                    break;
                case '8':
                    if (num.charAt(len - 1 - i) != '8') return false;
                    break;
                case '9':
                    if (num.charAt(len - 1 - i) != '6') return false;
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        StrobogrammaticNumber instance = new StrobogrammaticNumber();
        System.out.println(instance.isStrobogrammatic("69"));
        System.out.println(instance.isStrobogrammatic("99"));
        System.out.println(instance.isStrobogrammatic("88"));
        System.out.println(instance.isStrobogrammatic("818"));
    }
}
