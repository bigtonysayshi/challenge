package self;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Given a string representing arbitrarily nested ternary expressions,
 * calculate the result of the expression.
 * You can always assume that the given expression is valid and only consists of
 * digits 0-9, ?, :, T and F (T and F represent True and False respectively).
 * Note:
 * The length of the given string is ≤ 10000.
 * Each number will contain only one digit.
 * The conditional expressions group right-to-left (as usual in most languages).
 * The condition will always be either T or F. That is, the condition will never be a digit.
 * The result of the expression will always evaluate to either a digit 0-9, T or F.
 */
public class TernaryExpressionParser {
    // Time: O(n) Space: O(1)
    public String parseTernary(String expression) {
        if (expression.length() <= 1) return expression;
        int extra = 0;
        int i = 2;
        for (; i < expression.length(); i++) {
            if (expression.charAt(i) == '?') {
                extra++;
            } else if (expression.charAt(i) == ':') {
                if (extra == 0) {
                    break;
                } else {
                    extra--;
                }
            }
        }
        return expression.charAt(0) == 'T' ? parseTernary(expression.substring(2,i)) :
                parseTernary(expression.substring(i+1));
    }

    // nice solution using Stack
    public String parseTernary2(String expression) {
        if (expression == null || expression.length() == 0) return "";
        Stack<Character> stack = new Stack<>();

        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);
            if (!stack.isEmpty() && stack.peek() == '?') {

                stack.pop(); //pop '?'
                char first = stack.pop();
                stack.pop(); //pop ':'
                char second = stack.pop();

                if (c == 'T') stack.push(first);
                else stack.push(second);
            } else {
                stack.push(c);
            }
        }

        return String.valueOf(stack.peek());
    }

    public static void main(String[] args){
        TernaryExpressionParser instance = new TernaryExpressionParser();
        System.out.println(instance.parseTernary("T?2:3"));
        System.out.println(instance.parseTernary("F?1:T?4:5"));
        System.out.println(instance.parseTernary("T?T?F:5:3"));
        System.out.println(instance.parseTernary("F?T?3:2:F?4:1"));
        System.out.println(instance.parseTernary("3"));
    }
}
