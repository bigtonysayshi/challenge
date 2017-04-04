package self;

/**
 * Compute and return the square root of x.
 */
public class Sqrt {
    // Time: O(logn) Space: O(1)
    public int mySqrt(int x) {
        long lo = 0, hi = x;
        while (lo + 1 < hi) {
            long mid = lo + (hi - lo) / 2;
            if (mid * mid <= x) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        if (hi * hi <= x) {
            return (int)hi;
        }
        return (int)lo;
    }

    public static void main(String[] args){
        Sqrt instance = new Sqrt();
        System.out.println(instance.mySqrt(0));
        System.out.println(instance.mySqrt(1));
        System.out.println(instance.mySqrt(4));
        System.out.println(instance.mySqrt(9));
        System.out.println(instance.mySqrt(10));
        System.out.println(instance.mySqrt(99));
        System.out.println(instance.mySqrt(2147395599));
    }
}
