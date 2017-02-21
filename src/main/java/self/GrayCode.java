package self;

import java.util.LinkedList;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code,
 * print the sequence of gray code. A gray code sequence must begin with 0.
 * Note:
 * For a given n, a gray code sequence is not uniquely defined.
 * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 * For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> results = new LinkedList<>();
        if (n == 0) {
            results.add(0);
        } else if (n == 1) {
            results.add(0);
            results.add(1);
        } else if (n > 1) {
            List<Integer> sub = grayCode(n - 1);
            results.addAll(sub);
            for (int i = sub.size() - 1; i >= 0; i--) {
                results.add(sub.get(i) | (1 << (n - 1)));
            }
        }
        return results;
    }

    public static void main(String[] args){
        GrayCode instance = new GrayCode();
        System.out.println(instance.grayCode(2));
        System.out.println(instance.grayCode(3));
        System.out.println(instance.grayCode(4));
    }
}
