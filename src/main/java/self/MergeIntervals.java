package self;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 */
public class MergeIntervals {
    // Time: O(nlogn) Space: O(n)
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) {
            return new LinkedList<>();
        }
        Collections.sort(intervals, (Interval i1, Interval i2) -> Integer.compare(i1.start, i2.start));
        List<Interval> results = new LinkedList<>();
        Interval current = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval next = intervals.get(i);
            if (next.start > current.end) {
                results.add(current);
                current = next;
            } else if (next.end > current.end) {
                current.end = next.end;
            }
        }
        results.add(current);
        return results;
    }
}
