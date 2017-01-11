package self;

import java.util.HashMap;

/**
 * You are playing the following Bulls and Cows game with your friend:
 * You write down a number and ask your friend to guess what the number is.
 * Each time your friend makes a guess,
 * you provide a hint that indicates how many digits in said guess match your secret number exactly
 * in both digit and position (called "bulls") and how many digits match the secret number
 * but locate in the wrong position (called "cows").
 * Your friend will use successive guesses and hints to eventually derive the secret number.
 * Write a function to return a hint according to the secret number and friend's guess,
 * use A to indicate the bulls and B to indicate the cows. In the above example,
 * your function should return "1A3B".
 */
public class BullsAndCows {
    // Time: O(n) Space: O(1)
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] counts = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            int sc = Character.getNumericValue(secret.charAt(i));
            int gc = Character.getNumericValue(guess.charAt(i));
            if (sc == gc) {
                bulls++;
            } else {
                if (counts[sc] < 0) cows++;
                if (counts[gc] > 0) cows++;
                counts[sc]++;
                counts[gc]--;
            }
        }
        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args){
        BullsAndCows instance = new BullsAndCows();
        System.out.println(instance.getHint("1807", "7810"));
        System.out.println(instance.getHint("1123", "0111"));
    }
}
