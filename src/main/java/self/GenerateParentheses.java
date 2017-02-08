package self;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
public class GenerateParentheses {
    // Backtracking
    // Time: O(2^n) Space:O(2^n)
    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        generate(results, new StringBuilder(), n, 0, 0);
        return results;
    }

    private void generate(List<String> results, StringBuilder sb, int left, int right, int len) {
        if (left == 0) {
            for (int i = 0; i < right; i++) {
                sb.append(')');
            }
            results.add(sb.toString());
            return;
        }
        sb.append('(');
        generate(results, sb, left-1, right+1, len+1);
        sb.setLength(len);

        if (right > 0) {
            sb.append(')');
            generate(results, sb, left, right-1, len+1);
            sb.setLength(len);
        }
    }

    public static void main(String[] args){
        GenerateParentheses instance = new GenerateParentheses();
        System.out.println(instance.generateParenthesis(1));
        System.out.println(instance.generateParenthesis(3));
        System.out.println(instance.generateParenthesis(5));
    }
}
