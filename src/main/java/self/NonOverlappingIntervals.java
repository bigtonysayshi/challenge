package self;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 * Note:
 * You may assume the interval's end point is always bigger than its start point.
 * Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
 */
public class NonOverlappingIntervals {
    // Time: O(nlogn) Space: O(1)
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (Interval i1, Interval i2) -> i1.end - i2.end);
        int count = 1, end = intervals[0].end;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= end) {
                count++;
                end = intervals[i].end;
            }
        }
        return intervals.length - count;
    }
}
