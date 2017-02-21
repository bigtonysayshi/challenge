package self;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new LinkedList<>();
        findCombos(n, k, results, new LinkedList<>());
        return results;
    }

    private void findCombos(int n, int k, List<List<Integer>> results, List<Integer> combo) {
        if (n < 0) return;
        if (combo.size() == k) {
            results.add(new ArrayList<>(combo));
            return;
        }
        combo.add(n);
        findCombos(n-1, k, results, combo);
        combo.remove(combo.size()-1);
        findCombos(n-1, k, results, combo);
    }


    public static void main(String[] args){
        Combinations instance = new Combinations();
        System.out.println(instance.combine(4,2));
    }
}
