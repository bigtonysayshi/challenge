package self;

import java.util.*;

/**
 * Design a data structure that supports all following operations in average O(1) time.
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements.
 * Each element must have the same probability of being returned.
 */
public class InsertDeleteGetRandomO1 {
    List<Integer> dataList;
    Map<Integer, Integer> idxMap;
    Random rand;
    int nextIdx;


    /** Initialize your data structure here. */
    public InsertDeleteGetRandomO1() {
        dataList = new ArrayList<>();
        idxMap = new HashMap<>();
        rand = new Random();
        nextIdx = 0;
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (idxMap.containsKey(val)) return false;
        if (nextIdx < dataList.size()) {
            dataList.set(nextIdx, val);
        } else {
            dataList.add(val);
        }
        idxMap.put(val, nextIdx++);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!idxMap.containsKey(val)) return false;
        int idx = idxMap.get(val);
        if (idx < nextIdx - 1) {
            int lastVal = dataList.get(nextIdx  - 1);
            dataList.set(idx, lastVal);
            idxMap.put(lastVal, idx);
        }
        nextIdx--;
        idxMap.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return dataList.get(rand.nextInt(nextIdx));
    }
}
