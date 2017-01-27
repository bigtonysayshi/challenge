package self;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * You are playing the following Flip Game with your friend:
 * Given a string that contains only these two characters: + and -,
 * you and your friend take turns to flip two consecutive "++" into "--".
 * The game ends when a person can no longer make a move and therefore the other person will be the winner.
 * Write a function to determine if the starting player can guarantee a win.
 */
public class FlipGame2 {
    // Time: O(n!!) Space: O(2^n)
    public boolean canWin(String s) {
        Set<String> winSet = new HashSet<>();
        return canWin(s, winSet);
    }

    private boolean canWin(String s, Set<String> winSet) {
        if (winSet.contains(s)) return true;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i+1) == '+') {
                String modified = s.substring(0,i) + "--";
                if (i < s.length()) modified += s.substring(i+2);
                if (!canWin(modified)) {
                    winSet.add(s);
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        FlipGame2 instance = new FlipGame2();
        System.out.println(instance.canWin("++++"));
        System.out.println(instance.canWin("++"));
        System.out.println(instance.canWin("+++++"));
    }
}
