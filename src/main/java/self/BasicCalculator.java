package self;

import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -,
 * non-negative integers and empty spaces .
 * You may assume that the given expression is always valid.
 */
public class BasicCalculator {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int number = 0;
        int sign = 1; // 1 for positive, -1 for negative
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop(); // * prev sign
                result += stack.pop(); // + prev result
            }
        }
        result += sign * number;
        return result;
    }

    public static void main(String[] args){
        BasicCalculator instance = new BasicCalculator();
        System.out.println(instance.calculate("1 + 1"));
        System.out.println(instance.calculate(" 2-1 + 2 "));
        System.out.println(instance.calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(instance.calculate("2-(5-6)"));

    }
}
