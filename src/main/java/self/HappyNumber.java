package self;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number is "happy".
 * A happy number is a number defined by the following process: Starting with any positive integer,
 * replace the number by the sum of the squares of its digits,
 * and repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy numbers.
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> prevNumbers = new HashSet<Integer>();
        int number = n;
        while (number != 1 && !prevNumbers.contains(number)) {
            prevNumbers.add(number);
            number = getNextNumber(number);
        }
        return number == 1;
    }

    private int getNextNumber(int n) {
        int nextNumber = 0;
        while (n > 0) {
            nextNumber += Math.pow(n % 10, 2);
            n /= 10;
        }
        return nextNumber;
    }

    public static void main(String[] args){
        HappyNumber instance = new HappyNumber();
        System.out.println(instance.isHappy(1));
        System.out.println(instance.isHappy(19));
        System.out.println(instance.isHappy(238));

    }
}
