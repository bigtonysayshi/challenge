package self;

/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers
 * in this range, inclusive.
 */
public class BitwiseANDOfNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        int res = 0;
        int digit = 31;
        while (digit >= 0) {
            if ((m & (1 << digit)) == (n & (1 << digit))) {
                res |= (m & (1 << digit));
                digit--;
            } else {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args){
        BitwiseANDOfNumbersRange instance = new BitwiseANDOfNumbersRange();
        System.out.println(instance.rangeBitwiseAnd(5,7));
    }
}
