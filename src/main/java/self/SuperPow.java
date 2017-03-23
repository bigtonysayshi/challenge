package self;

/**
 * Your task is to calculate ab mod 1337 where a is a positive integer and b is
 * an extremely large positive integer given in the form of an array.
 */
public class SuperPow {
    // Time: O(n) Space: O(1)
    public int superPow(int a, int[] b) {
        int base = 1337;
        int n = b.length;
        int result = 1;
        for (int i = 0; i < n; i++) {
            result = (powMod(result, 10, base) * powMod(a, b[i], base)) % base;
        }
        return result;
    }

    private int powMod(int a, int b, int base) {
        a %= base;
        int res = 1;
        for (int i = 0; i < b; i++) {
            res = (res * a) % base;
        }
        return res;
    }

    public static void main(String[] args){
        SuperPow instance = new SuperPow();
        System.out.println(instance.superPow(2, new int[]{3}));
        System.out.println(instance.superPow(2, new int[]{1, 0}));
        System.out.println(instance.superPow(2147483647, new int[]{2, 0, 0}));
    }
}
