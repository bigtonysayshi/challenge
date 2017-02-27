package self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new LinkedList<>();
        Arrays.sort(candidates);
        findCombo(candidates, target, 0, results, new LinkedList<>());
        return results;
    }

    private void findCombo(int[] candidates, int target, int start, List<List<Integer>> results, List<Integer> combo) {
        if (target < 0) return;
        if (target == 0) {
            results.add(new ArrayList<>(combo));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            int num = candidates[i];
            combo.add(num);
            findCombo(candidates, target - num, i, results, combo);
            combo.remove(combo.size() - 1);
        }
    }

    public static void main(String[] args){
        CombinationSum instance = new CombinationSum();
        System.out.println(instance.combinationSum(new int[]{2,3,6,7}, 7));
    }
}
