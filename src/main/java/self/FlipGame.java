package self;

import java.util.ArrayList;
import java.util.List;

/**
 * You are playing the following Flip Game with your friend:
 * Given a string that contains only these two characters: + and -,
 * you and your friend take turns to flip two consecutive "++" into "--".
 * The game ends when a person can no longer make a move and therefore the other person will be the winner.
 * Write a function to compute all possible states of the string after one valid move.
 */
public class FlipGame {
    // Time:O(n^2) Space:O(n^2)
    public List<String> generatePossibleNextMoves(String s) {
        List<String> nextMoves = new ArrayList<>();
        if (s == null || s.length() < 2) return nextMoves;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i+1) == '+') {
                char[] charArray = s.toCharArray();
                charArray[i] = '-';
                charArray[i+1] = '-';
                nextMoves.add(String.copyValueOf(charArray));
            }
        }
        return nextMoves;
    }

    public static void main(String[] args){
        FlipGame instance = new FlipGame();
        System.out.println(instance.generatePossibleNextMoves("++++"));
    }
}
