package self;

import java.util.Arrays;

/**
 * There are a number of spherical balloons spread in two-dimensional space.
 * For each balloon, provided input is the start and end coordinates of the horizontal diameter.
 * Since it's horizontal, y-coordinates don't matter and hence the x-coordinates of start and end of the diameter suffice.
 * Start is always smaller than end. There will be at most 10^4 balloons.
 * An arrow can be shot up exactly vertically from different points along the x-axis.
 * A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend.
 * There is no limit to the number of arrows that can be shot.
 * An arrow once shot keeps travelling up infinitely.
 * The problem is to find the minimum number of arrows that must be shot to burst all balloons.
 */
public class MinimumNumberOfArrowsToBurstBalloons {
    // Time: O(nlogn) Space: O(1)
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (int[]o1, int[]o2) -> o1[1] - o2[1]);
        int shots = 0, lastEnd = -1;
        for (int i = 0; i < points.length; i++) {
            if (lastEnd == -1 || lastEnd < points[i][0]) {
                shots++;
                lastEnd = points[i][1];
            }
        }
        return shots;
    }

    public static void main(String[] args){
        MinimumNumberOfArrowsToBurstBalloons instance = new MinimumNumberOfArrowsToBurstBalloons();
        System.out.println(instance.findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}}));
    }
}
