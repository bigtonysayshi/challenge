package self;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, return 1 - n in lexicographical order.
 * For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
 * Please optimize your algorithm to use less time and space.
 * The input size may be as large as 5,000,000.
 */
public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> results = new ArrayList<>(n);
        int curr = 1;
        for (int i = 1; i <= n; i++) {
            results.add(curr);
            if (curr * 10 <= n) {
                curr *= 10;
            } else if (curr % 10 != 9 && curr + 1 <= n) {
                curr++;
            } else {
                while ((curr / 10) % 10 == 9) {
                    curr /= 10;
                }
                curr = curr / 10 + 1;
            }
        }
        return results;
    }


    public static void main(String[] args){
        LexicographicalNumbers instance = new LexicographicalNumbers();
        System.out.println(instance.lexicalOrder(8));
        System.out.println(instance.lexicalOrder(13));
        System.out.println(instance.lexicalOrder(103));
    }
}
