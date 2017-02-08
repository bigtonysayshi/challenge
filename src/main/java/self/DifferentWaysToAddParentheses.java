package self;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string of numbers and operators, return all possible results from computing all the
 * different possible ways to group numbers and operators. The valid operators are +, - and *.
 */
public class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> values = new ArrayList<>();
        List<Integer> opIdx = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                opIdx.add(i);
            }
        }
        if (opIdx.isEmpty()) {
            values.add(Integer.parseInt(input));
            return values;
        }
        for (int idx : opIdx) {
            List<Integer> left = diffWaysToCompute(input.substring(0, idx));
            List<Integer> right = diffWaysToCompute(input.substring(idx+1));
            for (int l : left) {
                for (int r : right) {
                    char c = input.charAt(idx);
                    if (c == '+') {
                        values.add(l + r);
                    } else if (c == '-') {
                        values.add(l - r);
                    } else if (c == '*') {
                        values.add(l * r);
                    }
                }
            }
        }
        return values;
    }

    public static void main(String[] args){
        DifferentWaysToAddParentheses instance = new DifferentWaysToAddParentheses();
        System.out.println(instance.diffWaysToCompute("2-1-1"));
        System.out.println(instance.diffWaysToCompute("2*3-4*5"));
    }
}
