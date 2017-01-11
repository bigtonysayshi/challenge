package self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Assume you are an awesome parent and want to give your children some cookies.
 * But, you should give each child at most one cookie.
 * Each child i has a greed factor gi, which is the minimum size of a cookie that the child will be content with;
 * and each cookie j has a size sj. If sj >= gi, we can assign the cookie j to the child i,
 * and the child i will be content.
 * Your goal is to maximize the number of your content children and output the maximum number.
 * Note: You may assume the greed factor is always positive.
 * You cannot assign more than one cookie to one child.
 */
public class AssignCookies {
    // Time:O(mlogm + nlogn) Space: O(m+n)
    public int findContentChildren(int[] g, int[] s) {
        int[] sortedGreeds = g.clone();
        Arrays.sort(sortedGreeds);
        int[] sortedSizes = s.clone();
        Arrays.sort(sortedSizes);
        int i = 0, j = 0, total = 0, m = g.length, n = s.length;
        while (i < m && j < n) {
            if (sortedGreeds[i] <= sortedSizes[j]) {
                total++;
                i++;
            }
            j++;
        }
        return total;
    }

    public static void main(String[] args){
        AssignCookies instance = new AssignCookies();
        System.out.println(instance.findContentChildren(new int[]{1,2,3}, new int[]{1,1}));
        System.out.println(instance.findContentChildren(new int[]{1,2}, new int[]{1,2,3}));
    }
}
