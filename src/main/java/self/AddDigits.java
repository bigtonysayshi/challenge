package self;

/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * For example: Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2.
 * Since 2 has only one digit, return it.
 * Could you do it without any loop/recursion in O(1) runtime?
 */
public class AddDigits {
    public int addDigits(int num) {
        while (num >= 10) {
            num = num / 10 + num % 10;
        }
        return num;
    }

    // Constant time using digital root formula
    public int addDigits2(int num) {
        return num - 9 * ((num - 1) / 9);
    }

    public static void main(String[] args){
        AddDigits instance = new AddDigits();
        System.out.println(instance.addDigits2(38));
    }
}
