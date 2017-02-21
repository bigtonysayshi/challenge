package self;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a nested list of integers, implement an iterator to flatten it.
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 */
public class FlattenNestedListIterator {
    private List<Integer> values;
    private int idx;

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        values = new LinkedList<>();
        extractValues(nestedList);
        idx = 0;
    }

    private void extractValues(List<NestedInteger> list) {
        for (NestedInteger ni : list) {
            if (ni.isInteger()) {
                values.add(ni.getInteger());
            } else {
                extractValues(ni.getList());
            }
        }
    }

//    @Override
    public Integer next() {
        return values.get(idx++);
    }

//    @Override
    public boolean hasNext() {
        return idx < values.size();
    }
}
