package self;

/**
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 */
public class SumOfTwoIntegers {
    // Time: O(n) Space: O(1)
    public int getSum(int a, int b) {
        while(b != 0) {
            int c = a ^ b; // get diff bits
            b = (a & b) << 1; // get carry bits
            a = c;
        }
        return a;
    }

    public static void main(String[] args){
        SumOfTwoIntegers instance = new SumOfTwoIntegers();
        System.out.println(instance.getSum(2, 3));
        System.out.println(instance.getSum(5, 6));
        System.out.println(instance.getSum(87, 13));


    }
}
