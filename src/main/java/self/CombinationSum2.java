package self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>>results = new ArrayList<>();
        findCombo(results, new ArrayList<>(), candidates, 0, target);
        return results;
    }

    private void findCombo(List<List<Integer>>results,
                           List<Integer> combo, int[] candidates, int startIdx, int target) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            results.add(new ArrayList<>(combo));
            return;
        }
        for (int i = startIdx; i < candidates.length; i++) {
            if (i != startIdx && candidates[i] == candidates[i-1]) {
                continue;
            }
            combo.add(candidates[i]);
            findCombo(results, combo, candidates, i + 1, target - candidates[i]);
            combo.remove(combo.size() - 1);
        }
    }

    public static void main(String[] args){
        CombinationSum2 instance = new CombinationSum2();
        System.out.println(instance.combinationSum2(new int[]{1}, 1));
        System.out.println(instance.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }
}
