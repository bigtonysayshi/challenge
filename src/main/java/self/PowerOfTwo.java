package self;

/**
 * Given an integer, write a function to determine if it is a power of two.
 */
public class PowerOfTwo {
    // Time: O(log n) Space: O(log n)
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        if (n % 2 != 0) return false;
        return isPowerOfTwo(n / 2);
    }

    // a power of two in binary form has and only has one "1".
    public boolean isPowerOfTwo2(int n) {
        return n>0 && Integer.bitCount(n) == 1;
    }

    public static void main(String[] args){
        PowerOfTwo instance = new PowerOfTwo();
        System.out.println(instance.isPowerOfTwo(0));
        System.out.println(instance.isPowerOfTwo(1));
        System.out.println(instance.isPowerOfTwo(2));
        System.out.println(instance.isPowerOfTwo(5));
        System.out.println(instance.isPowerOfTwo(1024));
    }
}
