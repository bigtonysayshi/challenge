package self;

import java.util.Arrays;

/**
 * Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.
 * Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that all houses could be covered by those heaters.
 * So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum radius standard of heaters.
 */
public class Heaters {
    // Time: O(nlogn + mlogm) Space: O(max(m,n))
    public int findRadius(int[] houses, int[] heaters) {
        if (houses.length == 0) return 0;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int idx = 0, minRad = 0;
        for (int h : houses) {
            while (idx < heaters.length - 1 && heaters[idx] + heaters[idx+1] <= 2*h ) {
                idx++;
            }
            minRad = Math.max(minRad, Math.abs(heaters[idx] - h));
        }
        return minRad;
    }

    public static void main(String[] args){
        Heaters instance = new Heaters();
        System.out.println(instance.findRadius(new int[]{1, 2, 3}, new int[]{2}));
        System.out.println(instance.findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4}));
        System.out.println(instance.findRadius(new int[]{282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923},
                new int[]{823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612}));

    }
}
