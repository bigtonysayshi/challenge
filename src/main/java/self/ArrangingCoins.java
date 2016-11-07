package self;

/**
 * You have a total of n coins that you want to form in a staircase shape,
 * where every k-th row must have exactly k coins.
 * Given n, find the total number of full staircase rows that can be formed.
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 */
public class ArrangingCoins {
    // binary search
    public int arrangeCoins(int n) {
        int start = 0;
        int end = n;
        int mid = 0;
        while (start <= end){
            mid = (start + end) / 2;
            if ((0.5 * mid * mid + 0.5 * mid ) <= n){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return start - 1;
    }

    public static void main(String[] args){
        ArrangingCoins instance = new ArrangingCoins();
        System.out.println(instance.arrangeCoins(0));
        System.out.println(instance.arrangeCoins(5));
        System.out.println(instance.arrangeCoins(8));
        System.out.println(instance.arrangeCoins(10));
    }
}
