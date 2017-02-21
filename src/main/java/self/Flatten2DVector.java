package self;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implement an iterator to flatten a 2d vector.
 */
public class Flatten2DVector {
    private Iterator<List<Integer>> outerIterator;
    private Iterator<Integer> innerIterator;

    public Flatten2DVector(List<List<Integer>> vec2d) {
        outerIterator = vec2d.iterator();
    }

//    @Override
    public Integer next() {
        return innerIterator.next();
    }

//    @Override
    public boolean hasNext() {
        while (innerIterator == null || !innerIterator.hasNext()) {
            if (!outerIterator.hasNext()) {
                return false;
            } else {
                innerIterator = outerIterator.next().iterator();
            }
        }
        return true;
    }
}
