package self;

/**
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
 * Note: n is positive and will fit within the range of a 32-bit signed integer (n < 2^31).
 */
public class NthDigit {
    public int findNthDigit(int n) {
        int digits = 1;
        long count = 9;
        while (n > digits * count ) {
            n -= digits * count;
            digits++;
            count *= 10;
        }
        int resultNum = (int) Math.pow(10, digits - 1) + (n - 1) / digits;
        String resultStr = String.valueOf(resultNum);
        int idx = (n - 1) % digits;
        return Character.getNumericValue(resultStr.charAt(idx));
    }

    public static void main(String[] args){
        NthDigit instance = new NthDigit();
        System.out.println(instance.findNthDigit(3));
        System.out.println(instance.findNthDigit(10));
        System.out.println(instance.findNthDigit(11));
        System.out.println(instance.findNthDigit(1000000000));
    }
}
