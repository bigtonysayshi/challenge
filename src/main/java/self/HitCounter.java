package self;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Design a hit counter which counts the number of hits received in the past 5 minutes.
 * Each function accepts a timestamp parameter (in seconds granularity) and you may assume that
 * calls are being made to the system in chronological order
 * (ie, the timestamp is monotonically increasing).
 * You may assume that the earliest timestamp starts at 1.
 * It is possible that several hits arrive roughly at the same time.
 */
public class HitCounter {
    private static final int WINDOW_NUM_SECONDS = 300;

    private Queue<Integer> hits;
    /** Initialize your data structure here. */
    public HitCounter() {
        hits = new LinkedList<>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        hits.add(timestamp);
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while (!hits.isEmpty() && hits.peek() <= timestamp - WINDOW_NUM_SECONDS) {
            hits.poll();
        }
        return hits.size();
    }
}

class HitCounter2 {
    private static final int WINDOW_NUM_SECONDS = 300;

    private HitCounts[] hitCounts;

    /** Initialize your data structure here. */
    public HitCounter2() {
        hitCounts = new HitCounts[WINDOW_NUM_SECONDS];
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int index = timestamp % WINDOW_NUM_SECONDS;
        HitCounts currentCounts = hitCounts[index];
        if (currentCounts.timestamp != timestamp) {
            currentCounts.count = 1;
            currentCounts.timestamp = timestamp;
        } else {
            currentCounts.count++;
        }
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int count = 0;
        for (int i = 0; i < WINDOW_NUM_SECONDS; i++) {
            if (hitCounts[i].timestamp > timestamp - WINDOW_NUM_SECONDS) {
                count += hitCounts[i].count;
            }
        }
        return count;
    }
}

class HitCounts {
    int timestamp;
    int count;

    public HitCounts(int timestamp, int count) {
        this.timestamp = timestamp;
        this.count = count;
    }
}