package self;

/**
 * You are playing the following Nim Game with your friend:
 * There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones.
 * The one who removes the last stone will be the winner.
 * You will take the first turn to remove the stones.
 * Both of you are very clever and have optimal strategies for the game.
 * Write a function to determine whether you can win the game given the number of stones in the heap.
 */
public class NimGame {
    // Time: O(1) Space: O(1)
    public boolean canWinNim(int n) {
        return n > 0 && n % 4 != 0;
    }

    public static void main(String[] args){
        NimGame instance = new NimGame();
        System.out.println(instance.canWinNim(4));
        System.out.println(instance.canWinNim(5));
        System.out.println(instance.canWinNim(500000));

    }
}
