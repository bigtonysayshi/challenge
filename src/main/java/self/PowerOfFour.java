package self;

/**
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 * Follow up: Could you solve it without loops/recursion?
 */
public class PowerOfFour {
    public boolean isPowerOfFour(int num) {
        // (num&(num-1) to make sure only 1 bit set
        // (num & 0x55555555) != 0 to make sure the bit is at odd position
        return num > 0 && (num&(num-1)) == 0 && (num & 0x55555555) != 0;
    }

    public static void main(String[] args){
        PowerOfFour instance = new PowerOfFour();
        System.out.println(instance.isPowerOfFour(0));
        System.out.println(instance.isPowerOfFour(1));
        System.out.println(instance.isPowerOfFour(5));
        System.out.println(instance.isPowerOfFour(16));
        System.out.println(instance.isPowerOfFour(256));
    }
}
