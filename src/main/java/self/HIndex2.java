package self;

/**
 * Follow up for H-Index: What if the citations array is sorted in ascending order?
 * Could you optimize your algorithm?
 */
public class HIndex2 {
    // Time: O(logn) Space: O(1)
    public int hIndex(int[] citations) {
        int n = citations.length;
        int lo = 0, hi = n-1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (n - mid == citations[mid]) {
                return mid;
            } else if (n - mid > citations[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    public static void main(String[] args){
        HIndex instance = new HIndex();
        System.out.println(instance.hIndex(new int[]{0,1,3,5,6}));
        System.out.println(instance.hIndex(new int[]{0,0,0,1}));
        System.out.println(instance.hIndex(new int[]{0,0,0,1,2}));
        System.out.println(instance.hIndex(new int[]{0,0,0,0}));
        System.out.println(instance.hIndex(new int[]{1}));
        System.out.println(instance.hIndex(new int[]{0}));
    }
}
