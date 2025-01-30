package leetcode;
// https://leetcode.com/problems/two-sum/description/

// [[1,6]] -> [[1,6]]
// [[0,4],[2,6]] -> [[0,6]]
// [[0,4],[6,10]] -> [[0,4],[6,10]]
// [[0,10],[2,8]] -> [[0,10]]
// [[0,10],[2,4],[6,8]] -> [[0,10]]


import java.util.Arrays;

public class MergeIntervals {

    class Solution {
        public int[][] merge(int[][] intervals) {
            int len = intervals.length;
            if (len == 1) return intervals;
            int[][] sortedIntervals = sort(intervals);
            int[][] result = new int[sortedIntervals.length][sortedIntervals[0].length];
            result[0] = sortedIntervals[0];
            int i = 0;
            int j = 1;
            do {
                if (result[i][1] > sortedIntervals[j][1]) {
//                    result[i] = sortedIntervals[j];
//                    j++;
                } else if (result[i][1] > sortedIntervals[j][0]) {
                    result[i] = new int[]{result[i][0],sortedIntervals[j][1]};
//                    j++;
                } else {
                    i++;
                    result[i] = sortedIntervals[j];
                }
                j++;
            } while (j < len);
            return result;
        }

        int[][] sort(int[][] intervals) {
            int len = intervals.length;
            if (len == 1) {
                return intervals;
            }
//            if (len == 2) {
//                if (intervals[0][0] > intervals[1][0]) {
//                    return new int[][]{intervals[1], intervals[0]};
//                } else return intervals;
//            }

            int[][] first = sort(Arrays.copyOfRange(intervals, 0, len/2));
            int[][] second = sort(Arrays.copyOfRange(intervals, len/2, len-1));
            return merge(first, second);
        }

        int[][] merge(int[][] first, int[][] second) {
            int firstLength = first.length;
            int secondLength = second.length;
            int[][] result = new int[firstLength+secondLength][first[0].length];
            int firstPointer = 0;
            int secondPointer = 0;

            // 0,1,4,5
            do {
                if (secondPointer >= secondLength || firstPointer < firstLength && first[firstPointer][0] <= second[secondPointer][0]) {
                    result[firstPointer+secondPointer] = first[firstPointer];
                    firstPointer++;
                } else {
                    result[firstPointer+secondPointer] = second[secondPointer];
                    secondPointer++;
                }
            } while(firstPointer<firstLength || secondPointer<secondLength);
            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
        int[][] numbers = new int[][]{{0,10},{2,4},{6,8}};
        int[][] result = solution.merge(numbers);
        System.out.println(Arrays.toString(result));
    }
}
