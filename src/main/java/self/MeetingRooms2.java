package self;

import java.util.*;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...]
 * (si < ei), find the minimum number of conference rooms required.
 */
public class MeetingRooms2 {
    // Time: O(nlogn) Space: O(1)
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (Interval i1, Interval i2) -> i1.start - i2.start);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (Interval interval : intervals) {
            Integer firstEnd = minHeap.peek();
            if (!minHeap.isEmpty() && interval.start >= firstEnd) {
                minHeap.poll();
            }
            minHeap.offer(interval.end);
        }
        return minHeap.size();
    }

    public static void main(String[] args){
        MeetingRooms2 instance = new MeetingRooms2();
        Interval[] input = new Interval[4];
        input[0] = new Interval(6, 17);
        input[1] = new Interval(8, 9);
        input[2] = new Interval(11, 12);
        input[3] = new Interval(6, 9);
        System.out.println(instance.minMeetingRooms(input));

        Interval[] input2 = new Interval[2];
        input2[0] = new Interval(5, 9);
        input2[1] = new Interval(6, 9);
        System.out.println(instance.minMeetingRooms(input2));

    }
}
