package self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 */
public class PlusOne {
    // Time: O(n) Space: O(n)
    public int[] plusOne(int[] digits) {
        if (digits.length == 0) return digits;
        List<Integer> newDigits = new ArrayList<>();
        int carry = 1;
        for (int i = 0; i < digits.length; i++) {
            int digit = digits[digits.length - 1 - i];
            if (digit + carry == 10) {
                newDigits.add(0);
                carry = 1;
            } else {
                newDigits.add(digit + carry);
                carry = 0;
            }
        }
        if (carry == 1) newDigits.add(1);
        int[] result = new int[newDigits.size()];
        for (int i = 0; i < newDigits.size(); i++) {
            result[i] = newDigits.get(newDigits.size() - 1 - i);
        }
        return result;
    }

    // Cleaner solution
    public int[] plusOne2(int[] digits) {
        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newNumber = new int [n+1];
        newNumber[0] = 1;

        return newNumber;
    }

    public static void main(String[] args){
        PlusOne instance = new PlusOne();
        System.out.println(Arrays.toString(instance.plusOne(new int[]{9,9})));
        System.out.println(Arrays.toString(instance.plusOne(new int[]{3,2,2,3})));
    }
}
