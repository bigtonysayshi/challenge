package self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Write a program that outputs the string representation of numbers from 1 to n.
 * But for multiples of three it should output “Fizz” instead of the number and for the
 * multiples of five output “Buzz”.
 * For numbers which are multiples of both three and five output “FizzBuzz”.
 */
public class FizzBuzz {
    private static final int TEST_PARAM_N = 15;
    private static final List<String> EXPECTED_RESULT = Arrays.asList(
            "1",
            "2",
            "Fizz",
            "4",
            "Buzz",
            "Fizz",
            "7",
            "8",
            "Fizz",
            "Buzz",
            "11",
            "Fizz",
            "13",
            "14",
            "FizzBuzz");

    //Time: O(n) Space: O(n)
    public List<String> fizzBuzz(int n) {
        List<String> results = new ArrayList<String>();
        if (n < 1) {
            return results;
        }
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                results.add("FizzBuzz");
            } else if (i % 3 == 0) {
                results.add("Fizz");
            } else if (i % 5 == 0) {
                results.add("Buzz");
            } else {
                results.add(Integer.toString(i));
            }
        }

        return results;
    }

    private boolean verifyDefault() {
        List<String> actualResult = fizzBuzz(TEST_PARAM_N);
        return actualResult.equals(EXPECTED_RESULT);
    }

    public static void main(String[] args){
        FizzBuzz fizzBuzz = new FizzBuzz();
        boolean passed = fizzBuzz.verifyDefault();
        System.out.println(passed ? "Passed" : "Failed");
    }
}
