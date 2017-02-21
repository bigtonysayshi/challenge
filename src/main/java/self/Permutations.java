package self;

import java.util.*;

/**
 * Given a collection of distinct numbers, return all possible permutations.
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new LinkedList<>();
        permuteHelper(results, new LinkedList<>(), nums);
        return results;
    }

    private void permuteHelper(List<List<Integer>> results, List<Integer> perm, int[] nums) {
        if (perm.size() == nums.length) {
            results.add(new ArrayList<>(perm));
        } else {
            for (int n : nums) {
                if (!perm.contains(n)) {
                    perm.add(n);
                    permuteHelper(results, perm, nums);
                    perm.remove(perm.size()-1);
                }
            }
        }
    }

    public static void main(String[] args){
        Permutations instance = new Permutations();
        System.out.println(instance.permute(new int[]{1,2,3,4}));
    }
}
