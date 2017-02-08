package self;

/**
 * There are n bulbs that are initially off. You first turn on all the bulbs.
 * Then, you turn off every second bulb. On the third round, you toggle every third bulb
 * (turning on if it's off or turning off if it's on).
 * For the ith round, you toggle every i bulb. For the nth round, you only toggle the last bulb.
 * Find how many bulbs are on after n rounds.
 */
public class BulbSwitcher {
    // Only need to count the numbers with odd number of divisors (square numbers)
    // Time: O(1) Space: O(1)
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }

    public static void main(String[] args){
        BulbSwitcher instance = new BulbSwitcher();
        System.out.println(instance.bulbSwitch(3));
        System.out.println(instance.bulbSwitch(5));
        System.out.println(instance.bulbSwitch(10));
    }
}
