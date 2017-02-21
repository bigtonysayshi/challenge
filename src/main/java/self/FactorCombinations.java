package self;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Write a function that takes an integer n and return all possible combinations of its factors.
 * Note:You may assume that n is always positive.
 * Factors should be greater than 1 and less than n.
 */
public class FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> results = helper(n, 2);
        results = results.stream()
                .filter((List<Integer> l) -> l.size() > 1)
                .collect(Collectors.toList());
        return results;
    }

    private List<List<Integer>> helper(int n, int minFactor) {
        List<List<Integer>> results = new ArrayList<>();
        for (int i = minFactor; i * i <= n; i++) {
            if (n % i == 0) {
                List<List<Integer>> sub = helper(n/i, i);
                for (List<Integer> l : sub) {
                    l.add(i);
                    results.add(l);
                }
            }
        }
        List<Integer> self = new ArrayList<>();
        self.add(n);
        results.add(self);
        return results;
    }

    public static void main(String[] args){
        FactorCombinations instance = new FactorCombinations();
        System.out.println(instance.getFactors(1));
        System.out.println(instance.getFactors(12));
        System.out.println(instance.getFactors(32));
        System.out.println(instance.getFactors(37));
    }
}
