package self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space,
 * where n is the total number of rows in the triangle.
 */
public class Triangle {
    // Time: O(n^2) Space: O(n)
    public int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        List<Integer> prevSums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> row = triangle.get(i);
            List<Integer> sums = new ArrayList<>(i+1);
            if (i == 0) {
                sums.add(row.get(0));
            } else {
                for (int j = 0; j < row.size(); j++) {
                    int val = row.get(j);
                    int leftParent = j == 0 ? Integer.MAX_VALUE : prevSums.get(j-1);
                    int rightParent = j == row.size()-1 ? Integer.MAX_VALUE : prevSums.get(j);
                    sums.add(val + Math.min(leftParent, rightParent));
                }
            }
            prevSums = sums;
        }
        if (prevSums.isEmpty()) return 0;
        int minTotal = Integer.MAX_VALUE;
        for (int total : prevSums) {
            minTotal = Math.min(minTotal, total);
        }
        return minTotal;
    }

    //  Bottom Up
    // Time: O(n^2) Space: O(n)
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] minTotals = triangle.get(n-1).stream().mapToInt(i -> i).toArray();
        for (int i = n-2; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                minTotals[j] = Math.min(minTotals[j], minTotals[j+1]) + row.get(j);
            }
        }
        return minTotals[0];
    }

    public static void main(String[] args){
        Triangle instance = new Triangle();
        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(new Integer[]{2}));
        input.add(Arrays.asList(new Integer[]{3,4}));
        input.add(Arrays.asList(new Integer[]{6,5,7}));
        input.add(Arrays.asList(new Integer[]{4,1,8,3}));
        System.out.println(instance.minimumTotal(input));
    }
}
