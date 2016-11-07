package self;

/**
 * Given an integer, write a function to determine if it is a power of three.
 * Follow up: Could you do it without using any loop / recursion?
 */
public class PowerOfThree {
    // 1162261467 is 3^19,  3^20 is bigger than int
    public boolean isPowerOfThree(int n) {
        return ( n>0 && 1162261467 % n == 0);
    }

    public static void main(String[] args){
        PowerOfThree instance = new PowerOfThree();
        System.out.println(instance.isPowerOfThree(0));
        System.out.println(instance.isPowerOfThree(1));
        System.out.println(instance.isPowerOfThree(5));
        System.out.println(instance.isPowerOfThree(9));
        System.out.println(instance.isPowerOfThree(81));
    }
}

