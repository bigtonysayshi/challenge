package self;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Given a set of intervals, for each of the interval i, check if there exists an interval j
 * whose start point is bigger than or equal to the end point of the interval i,
 * which can be called that j is on the "right" of i.
 * For any interval i, you need to store the minimum interval j's index,
 * which means that the interval j has the minimum start point to build the "right" relationship for interval i.
 * If the interval j doesn't exist, store -1 for the interval i.
 * Finally, you need output the stored value of each interval as an array.
 * Note:
 * You may assume the interval's end point is always bigger than its start point.
 * You may assume none of these intervals have the same start point.
 */
public class FindRightInterval {
    // Time: O(n^2) Space: O(n)
    public int[] findRightInterval(Interval[] intervals) {
        int n = intervals.length;
        if (n == 0) return new int[]{};
        int[][] sortedIntervals = new int[n][3];
        for (int i = 0; i < n; i++) {
            Interval interval = intervals[i];
            sortedIntervals[i] = new int[]{interval.start, interval.end, i};
        }
        Arrays.sort(sortedIntervals, (int[] o1, int[]o2) -> o1[0] - o2[0]);
        int[] results = new int[n];
        Arrays.fill(results, -1);
        for (int i = 0; i < n-1; i++) {
            int[] left = sortedIntervals[i];
            for (int j = i+1; j < n; j++) {
                int[] right = sortedIntervals[j];
                if (right[0] >= left[1]) {
                    results[left[2]] = right[2];
                    break;
                }
            }
        }
        return results;
    }

    // UseTreeMap
    // Time: O(n logn) Space: O(n)
    public int[] findRightInterval2(Interval[] intervals) {
        int n = intervals.length;
        if (n == 0) return new int[]{};
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            treeMap.put(intervals[i].start, i);
        }
        int[] results = new int[n];
        for (int i = 0; i < n; i++) {
            Integer key = treeMap.ceilingKey(intervals[i].end);
            results[i] = key == null ? -1 : treeMap.get(key);
        }
        return results;
    }
}
