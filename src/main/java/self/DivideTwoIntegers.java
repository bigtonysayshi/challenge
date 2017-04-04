package self;

/**
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT.
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) return Integer.MAX_VALUE;
        boolean isNegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
        long big = Math.abs((long)dividend);
        long small = Math.abs((long)divisor);
        int val = 0;
        while (small <= big) {
            int shift = 0;
            while (big >= (small << shift)) {
                shift++;
            }
            big -= small << (shift - 1);
            val += 1 << (shift - 1);
        }
        return isNegative ? -val : val;
    }

    public static void main(String[] args){
        DivideTwoIntegers instance = new DivideTwoIntegers();
        System.out.println(instance.divide(100, 9));
        System.out.println(instance.divide(-100, 9));
        System.out.println(instance.divide(-1, 1));
        System.out.println(instance.divide(Integer.MIN_VALUE, 1));

    }
}
