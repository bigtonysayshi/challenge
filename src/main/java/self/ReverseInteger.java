package self;

/**
 * Reverse digits of an integer.
 */
public class ReverseInteger {
    public int reverse(int x) {
        if (x == 0) return 0;
        String str = Integer.toString(x);
        StringBuilder sb = new StringBuilder(str).reverse();
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        boolean negative = false;
        if (sb.charAt(sb.length() - 1) == '-') {
            negative = true;
            sb.deleteCharAt(sb.length() - 1);
        }
        String reverted = sb.toString();
        String maxInt = Integer.toString(Integer.MAX_VALUE);
        if (reverted.length() >= maxInt.length()  && reverted.compareTo(maxInt) > 0) {
            return 0;
        }
        return Integer.valueOf(reverted) * (negative ? -1 : 1);
    }

    // more elegant solution
    public int reverse2(int x) {
        long rev= 0;
        while( x != 0){
            rev= rev*10 + x % 10;
            x= x/10;
            if( rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE)
                return 0;
        }
        return (int) rev;
    }

    public static void main(String[] args){
        ReverseInteger instance = new ReverseInteger();
        System.out.println(instance.reverse(0));
        System.out.println(instance.reverse(123));
        System.out.println(instance.reverse(-123));
        System.out.println(instance.reverse(3));
        System.out.println(instance.reverse(2147483647));
        System.out.println(instance.reverse(-2147483647));
        System.out.println(instance.reverse(901000));
    }
}
