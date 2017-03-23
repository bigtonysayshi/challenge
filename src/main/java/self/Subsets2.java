package self;

import java.util.*;

/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.
 * Note: The solution set must not contain duplicate subsets.
 */
public class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> results = new HashSet<>();
        Arrays.sort(nums);
        findSubsets(results, new ArrayList<>(), nums, 0);
        return new ArrayList<>(results);
    }

    private void findSubsets(Set<List<Integer>> results, List<Integer> subset, int[] nums, int start) {
        results.add(new ArrayList<>(subset));
        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i-1]) {
                continue;
            }
            subset.add(nums[i]);
            findSubsets(results, subset, nums, i+1);
            subset.remove(subset.size() - 1);
        }
    }

    public static void main(String[] args){
        Subsets2 instance = new Subsets2();
        System.out.println(instance.subsetsWithDup(new int[]{1,2,2}));
    }
}
