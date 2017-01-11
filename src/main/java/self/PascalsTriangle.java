package self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 */
public class PascalsTriangle {
    // Time: O(n^2) Space: O(n^2)
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> prevLevel = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> newLevel = new ArrayList<>();
            if (i == 0) {
                newLevel.add(1);
            } else {
                newLevel.add(1);
                for (int j = 0; j < prevLevel.size()-1; j++) {
                    newLevel.add(prevLevel.get(j) + prevLevel.get(j+1));
                }
                newLevel.add(1);
            }
            result.add(newLevel);
            prevLevel = newLevel;
        }
        return result;
    }

    public static void main(String[] args){
        PascalsTriangle instance = new PascalsTriangle();
        System.out.println(instance.generate(5));
    }
}
