package self;

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Now your job is to find the total Hamming distance between all pairs of the given numbers.
 * Note:
 * Elements of the given array are in the range of 0 to 10^9
 * Length of the array will not exceed 10^4.
 */
public class TotalHammingDistance {
    // Time: O(n) Space: O(1)
    public int totalHammingDistance(int[] nums) {
        int totalDistance = 0;
        for (int k = 0; k < 31; k++) {
            int ones = 0, zeros = 0;
            for (int num : nums) {
                if ((num & (1 << k)) == (1 << k)) {
                    ones++;
                } else {
                    zeros++;
                }
            }
            if (ones > 0 && zeros > 0) totalDistance += ones * zeros;
        }
        return totalDistance;
    }

    public static void main(String[] args){
        TotalHammingDistance instance = new TotalHammingDistance();
        System.out.println(instance.totalHammingDistance(new int[]{4,14,2}));
    }
}
