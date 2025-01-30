package leetcode;
// https://leetcode.com/problems/two-sum/description/

// [0,0], 0 -> [0,1]
// [0,1], 1 -> [0,1]
// [1,1], 2 -> [0,1]
// [1,6,3,5,9], 8 -> [2,3]
// [4,6,1,5,9,4], 8 -> [0,5]
// [4,6,4,5,9,1], 8 -> [0,2]
// [1,6,4,5,9,4], 8 -> [2,5]

import java.util.Arrays;

public class TwoSum {

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int len = nums.length;
            if (len == 2) return new int[]{0,1};
            // 0,1 0,2 1,2
            for (int i = 0; i < len-1; i++) {
                for (int j = i+1; j < len; j++) {
                    if (nums[i]+nums[j] == target) return new int[]{i,j};
                }
            }
            return new int[]{};
        }
    }

    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
        int[] numbers = new int[]{4,6,1,5,9,4};
        int number = 8;
        int[] result = solution.twoSum(numbers, number);
        System.out.println(Arrays.toString(result));
    }
}
