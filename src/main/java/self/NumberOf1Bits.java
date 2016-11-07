package self;

/**
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has
 * (also known as the Hamming weight).
 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011,
 * so the function should return 3.
 */
public class NumberOf1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int num1Bits = 0;
        while (n != 0) {
            num1Bits += n & 1;
            n >>>= 1;
        }
        return num1Bits;
    }

    public static void main(String[] args){
        NumberOf1Bits instance = new NumberOf1Bits();
        System.out.println(instance.hammingWeight(1));
        System.out.println(instance.hammingWeight(2));
        System.out.println(instance.hammingWeight(11));
        System.out.println(instance.hammingWeight(20));
    }
}
