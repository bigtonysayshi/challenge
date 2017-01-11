package self;

import java.util.Arrays;

/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 * Assume that the total area is never beyond the maximum possible value of int.
 */
public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int overlapArea = 0;
        if (C > E && A < G && D > F && B < H) {
            int[] xCoords = new int[]{A, C, E, G};
            int[] yCoords = new int[]{B, D, F, H};
            Arrays.sort(xCoords);
            Arrays.sort(yCoords);
            overlapArea = (xCoords[2] - xCoords[1]) * (yCoords[2] - yCoords[1]);
        }
        return (D - B) * (C - A) + (H - F) * (G - E) - overlapArea;
    }

    public static void main(String[] args){
        RectangleArea instance = new RectangleArea();
        System.out.println(instance.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }
}
