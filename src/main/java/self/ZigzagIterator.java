package self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Given two 1d vectors, implement an iterator to return their elements alternately.
 * For example, given two 1d vectors:
 * v1 = [1, 2]
 * v2 = [3, 4, 5, 6]
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].
 * Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?
 */
public class ZigzagIterator {
    List<Iterator<Integer>> iterators;
    int current;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        iterators = new ArrayList<>();
        if (!v1.isEmpty()) {
            iterators.add(v1.iterator());
        }
        if (!v2.isEmpty()) {
            iterators.add(v2.iterator());
        }
        current = 0;
    }

    public int next() {
        Iterator<Integer> iterator = iterators.get(current);
        int val = iterator.next();
        if (!iterator.hasNext()) {
            iterators.remove(current);
        } else {
            current++;
        }
        if (!iterators.isEmpty()) {
            current = current % iterators.size();
        }
        return val;
    }

    public boolean hasNext() {
        return !iterators.isEmpty();
    }

    public static void main(String[] args){
        List<Integer> v1 = Arrays.asList(new Integer[]{1,2});
        List<Integer> v2 = Arrays.asList(new Integer[]{3,4,5,6});
        ZigzagIterator instance = new ZigzagIterator(v1, v2);
        while (instance.hasNext()) {
            System.out.println(instance.next());
        }
    }
}
