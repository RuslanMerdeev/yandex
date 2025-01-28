package leetcode;
// https://leetcode.com/problems/container-with-most-water/submissions/1522182617/

public class MostWater {

    class Solution {

        int area(int i1, int h1, int i2, int h2) {
            return (i2-i1)*Math.min(h1, h2);
        }

        int canStore(int[] height) {
            int i = 0;
            int j = height.length-1;
            int area = area(i, height[i], j, height[j]);
            while (j-i>1) {
                if (height[i]<height[j]) {
                    i++;
                } else {
                    j--;
                }
                int newArea = area(i, height[i], j, height[j]);
                if (newArea > area) {
                    area = newArea;
                }
            }

            return area;
        }
    }

    public static void main(String[] args) {
        MostWater.Solution solution = new MostWater().new Solution();
        int[] height = {2,3,4,5,18,17,6};
        int canStore = solution.canStore(height);
        System.out.println(canStore);
    }
}
