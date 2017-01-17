package self;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tzhang2 on 1/16/17.
 */
public class HitCounter {
    List<Integer> hits;
    int ts;
    /** Initialize your data structure here. */
    public HitCounter() {
        hits = new ArrayList<>();
        ts = -1;
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if (timestamp == ts) {
            hits.set(hits.size()-1, hits.get(hits.size()-1) + 1);
        } else {
            hits.add(timestamp);
            hits.add(1);
            ts = timestamp;
        }
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int total = 0;
        for (int i = 0; i < hits.size(); i += 2) {
            if (hits.get(i) > timestamp) {
                return total;
            } else if (timestamp - hits.get(i) < 300) {
                total += hits.get(i+1);
            }
        }
        return total;
    }
}
