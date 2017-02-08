package self;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n,
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 */
public class CombinationSum3 {
    // Backtracking
    // Time: O(1) Space:O(1)
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> results = new ArrayList<>();
        comboHelper(results, new ArrayList<>(), k, n, 1);
        return results;
    }

    private void comboHelper(List<List<Integer>> results,
                                            List<Integer> combo, int k, int n, int start) {
        if (combo.size() == k && n == 0) {
            List<Integer> validCombo = new ArrayList<>(combo);
            results.add(validCombo);
            return;
        }
        if (start > n || combo.size() == k) return;
        for (int i = start; i <= 9; i++) {
            combo.add(i);
            comboHelper(results, combo, k, n-i, i+1);
            combo.remove(combo.size() - 1);
        }
    }

    public static void main(String[] args){
        CombinationSum3 instance = new CombinationSum3();
        System.out.println(instance.combinationSum3(3, 7));
        System.out.println(instance.combinationSum3(3, 9));
        System.out.println(instance.combinationSum3(3, 15));
    }
}
