package self;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets.
 * Note: The solution set must not contain duplicate subsets.
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new LinkedList<>();
        findSubset(nums, 0, results, new LinkedList<>());
        return results;
    }

    private void findSubset(int[] nums, int start, List<List<Integer>> results, List<Integer> subset) {
        results.add(new ArrayList<>(subset));
        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            findSubset(nums, i + 1, results, subset);
            subset.remove(subset.size() - 1);
        }
    }

    public static void main(String[] args){
        Subsets instance = new Subsets();
        System.out.println(instance.subsets(new int[]{1,2,3}));
    }
}
