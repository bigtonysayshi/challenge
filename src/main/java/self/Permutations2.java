package self;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 */
public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashMap<Integer, Integer> candidates = new HashMap<>();
        for (int num : nums) {
            candidates.put(num, candidates.getOrDefault(num, 0) + 1);
        }
        List<List<Integer>> results = new ArrayList<>();
        search(candidates, nums.length, results, new ArrayList<>());
        return results;
    }

    private void search(HashMap<Integer, Integer> candidates, int numCandidates, List<List<Integer>> results, List<Integer> perm) {
        if (numCandidates == 0) {
            results.add(new ArrayList<>(perm));
            return;
        }
        for (Integer key : candidates.keySet()) {
            int val = candidates.get(key);
            if (val > 0) {
                candidates.put(key, val - 1);
                perm.add(key);
                search(candidates, numCandidates - 1, results, perm);
                perm.remove(perm.size() - 1);
                candidates.put(key, val);
            }
        }
    }

    public static void main(String[] args){
        Permutations2 instance = new Permutations2();
        System.out.println(instance.permuteUnique(new int[]{1,1,2}));
    }
}
