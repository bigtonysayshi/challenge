package self;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 */
public class PascalsTriangle2 {
    // Time: O(k^2) Space: O(k)
    public List<Integer> getRow(int rowIndex) {
        List<Integer> level = new ArrayList<>();
        if (rowIndex < 0) return level;
        for (int i = 0; i < rowIndex + 1; i++) {
            long num = 1;
            for (int j = 0; j < i; j++) {
                num *= (rowIndex - j);
                num /= (j + 1);
            }
            level.add((int)num);
        }
        return level;
    }

    public static void main(String[] args){
        PascalsTriangle2 instance = new PascalsTriangle2();
        System.out.println(instance.getRow(3));
        System.out.println(instance.getRow(30));

    }
}
