package self;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * Design and implement a data structure for Least Frequently Used (LFU) cache.
 * It should support the following operations: get and put.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present.
 * When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item.
 * For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.
 * Follow up: Could you do both operations in O(1) time complexity?
 */
public class LFUCache {
    private int capacity;
    private int minCount;
    private Map<Integer, Integer> cache;
    private Map<Integer, Integer> keyCountMap;
    private Map<Integer, LinkedHashSet<Integer>> countKeysMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minCount = -1;
        this.cache = new HashMap<>();
        this.keyCountMap = new HashMap<>();
        this.countKeysMap = new HashMap<Integer, LinkedHashSet<Integer>>() {{
            put(1, new LinkedHashSet<>());
        }};
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            incrementCount(key);
            return cache.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        if (cache.containsKey(key)) {
            incrementCount(key);
            cache.put(key, value);
            return;
        }
        if (cache.size() >= capacity) {
            int oldestKey = countKeysMap.get(minCount).iterator().next();
            countKeysMap.get(minCount).remove(oldestKey);
            keyCountMap.remove(oldestKey);
            cache.remove(oldestKey);
        }
        cache.put(key, value);
        keyCountMap.put(key, 1);
        countKeysMap.get(1).add(key);
        minCount = 1;
    }

    private void incrementCount(int key) {
        if (!keyCountMap.containsKey(key)) {
            return;
        }
        int currentCount = keyCountMap.get(key);
        keyCountMap.put(key, currentCount + 1);
        LinkedHashSet<Integer> currentCountKeys = countKeysMap.get(currentCount);
        currentCountKeys.remove(key);
        if (currentCount == minCount && currentCountKeys.isEmpty()) {
            minCount++;
        }
        if (!countKeysMap.containsKey(currentCount + 1)) {
            countKeysMap.put(currentCount + 1, new LinkedHashSet());
        }
        countKeysMap.get(currentCount + 1).add(key);
    }

    public static void main(String[] args){
        LFUCache instance = new LFUCache(2);
        instance.put(1,1);
        instance.put(2,2);
        System.out.println(instance.get(1));
        instance.put(3,3);
        System.out.println(instance.get(2));
        System.out.println(instance.get(3));
        instance.put(4,4);
        System.out.println(instance.get(1));
        System.out.println(instance.get(3));
        System.out.println(instance.get(4));

    }

}
