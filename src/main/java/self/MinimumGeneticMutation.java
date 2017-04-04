package self;

import java.util.Arrays;
import java.util.HashSet;

/**
 * A gene string can be represented by an 8-character long string, with choices from "A", "C", "G", "T".
 * Suppose we need to investigate about a mutation (mutation from "start" to "end"),
 * where ONE mutation is defined as ONE single character changed in the gene string.
 * For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.
 * Also, there is a given gene "bank", which records all the valid gene mutations.
 * A gene must be in the bank to make it a valid gene string.
 * Now, given 3 things - start, end, bank, your task is to determine what is the minimum number of
 * mutations needed to mutate from "start" to "end". If there is no such a mutation, return -1.
 * Note:
 * Starting point is assumed to be valid, so it might not be included in the bank.
 * If multiple mutations are needed, all mutations during in the sequence must be valid.
 * You may assume start and end string is not the same.
 */
public class MinimumGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {
        boolean[] checked = new boolean[bank.length];
        return dfs(start, end, bank, checked);
    }

    private int dfs(String current, String end, String[] bank, boolean[] checked) {
        if (end.equals(current)) {
            return 0;
        }
        int minSteps = -1;
        for (int i = 0; i < bank.length; i++) {
            if (checked[i]) {
                continue;
            }
            String mutation = bank[i];
            if (distance(mutation, current) != 1) {
                continue;
            }
            checked[i] = true;
            int count = dfs(mutation, end, bank, checked);
            if (count >= 0) {
                if (minSteps == -1 || count + 1 < minSteps) {
                    minSteps = count + 1;
                }
            }
            checked[i] = false;
        }
        return minSteps;
    }

    private int distance(String s1, String s2) {
        int res = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                res++;
            }
        }
        return res;
    }


    public static void main(String[] args){
        MinimumGeneticMutation instance = new MinimumGeneticMutation();
        System.out.println(instance.minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"}));
        System.out.println(instance.minMutation("AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"}));
        System.out.println(instance.minMutation("AACCTTGG", "AATTCCGG", new String[]{"AATTCCGG","AACCTGGG","AACCCCGG","AACCTACC"}));
    }
}
