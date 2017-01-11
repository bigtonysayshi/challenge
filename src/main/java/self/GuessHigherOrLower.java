package self;

/**
 * We are playing the Guess Game. The game is as follows:
 * I pick a number from 1 to n. You have to guess which number I picked.
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 * -1 : My number is lower
 * 1 : My number is higher
 * 0 : Congrats! You got it!
 */
public class GuessHigherOrLower extends GuessGame{
    // Time: O(logn) Space: O(1)
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (high >= low) {
            int g = low + (high - low) / 2;
            int res = guess(g);
            if (res == 0) {
                return g;
            } else if (res == -1) {
                high = g - 1;
            } else {
                low = g + 1;
            }
        }
        return -1;
    }

}
