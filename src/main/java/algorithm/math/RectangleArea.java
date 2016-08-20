package algorithm.math;

/**
 * https://leetcode.com/problems/rectangle-area/
 *
 Find the total area covered by two rectilinear rectangles in a 2D plane.

 Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

 https://leetcode.com/static/images/problemset/rectangle_area.png

 Assume that the total area is never beyond the maximum possible value of int.

 * @author xiaobaoqiu  Date: 16-7-4 Time: 下午10:45
 */
public class RectangleArea {
    public static void main(String[] args) {

    }

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int base = (C - A) * (D - B) + (G - E) * (H - F);
        //不相交
        if (C <= E || A >= G || B >= H || D <= F) {
            return base;
        }

        //TODO
        return 0;
    }
}
