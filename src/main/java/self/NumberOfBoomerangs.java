package self;

import java.util.HashMap;

/**
 * Given n points in the plane that are all pairwise distinct,
 * a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals
 * the distance between i and k (the order of the tuple matters).
 * Find the number of boomerangs. You may assume that n will be at most 500
 * and coordinates of points are all in the range [-10000, 10000] (inclusive).
 */
public class NumberOfBoomerangs {
    // Time: O(n^2) Space: O(n)
    public int numberOfBoomerangs(int[][] points) {
        int total = 0;
        for (int i = 0; i < points.length; i++) {
            int[] b = points[i];
            HashMap<Integer, Integer> distanceMap = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    int[] p = points[j];
                    int distance = (p[0] - b[0]) * (p[0] - b[0]) + (p[1] - b[1]) * (p[1] - b[1]);
                    int count = distanceMap.containsKey(distance) ? distanceMap.get(distance) : 0;
                    distanceMap.put(distance, count + 1);
                }
            }
            for (int count : distanceMap.values()) {
                if (count >= 2) {
                    total += count * (count - 1);
                }
            }
        }
        return total;
    }
}
