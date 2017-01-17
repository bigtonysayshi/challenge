package self;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 */
public class TwoSum3 {
    Map<Integer, Boolean> numsMap = new HashMap<>();
    // Add the number to an internal data structure.
    public void add(int number) {
        numsMap.put(number, numsMap.containsKey(number));
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        for (int n : numsMap.keySet()) {
            int r = value - n;
            if ((r == n && numsMap.get(n)) || (r != n && numsMap.containsKey(r))) {
                return true;
            }
        }
        return false;
    }
}
