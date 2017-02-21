package self;

/**
 * There is a list of sorted integers from 1 to n. Starting from left to right,
 * remove the first number and every other number afterward until you reach the end of the list.
 * Repeat the previous step again, but this time from right to left,
 * remove the right most number and every other number from the remaining numbers.
 * We keep repeating the steps again, alternating left to right and right to left,
 * until a single number remains.
 * Find the last number that remains starting with a list of length n.
 */
public class EliminationGame {
    // Time: O(logn) Space: O(1)
    public int lastRemaining(int n) {
        int head = 1, step = 1, rem = n;
        boolean left = true;
        while (rem > 1) {
            if (left || rem % 2 ==1) {
                head += step;
            }
            rem /= 2;
            step *= 2;
            left = !left;
        }
        return head;
    }


    public static void main(String[] args){
        EliminationGame instance = new EliminationGame();
        System.out.println(instance.lastRemaining(1));
        System.out.println(instance.lastRemaining(9));
        System.out.println(instance.lastRemaining(13));
        System.out.println(instance.lastRemaining(14));
        System.out.println(instance.lastRemaining(20));
    }
}
