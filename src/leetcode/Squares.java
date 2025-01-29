package leetcode;
// https://leetcode.com/problems/squares-of-a-sorted-array/description/

// [1,1,1] -> [1,1,1]
// [-10, -6, 0, 1, 13, 14] -> [0,1,36,100,169,194]
// [] -> []
// [3] -> [9]
// [1,2,3] -> [1,4,9]

import java.util.Arrays;

public class Squares {

    class Solution {

        int[] resolve(int[] nums) {
            int len = nums.length;
            int[] result = new int[len];
            if (len == 0) {
            } else if (len == 1) {
                result[0] = (int)Math.pow(nums[0],2);
            } else {
                int r = len-1;
                int pos = len-1;
                int l = 0;
                do {
                    if (Math.abs(nums[r]) > Math.abs(nums[l])) {
                        result[pos] = (int)Math.pow(nums[r],2);
                        r--;
                    } else {
                        result[pos] = (int)Math.pow(nums[l],2);
                        l++;
                    }
                    pos--;
                } while ( pos >= 0 );
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Squares().new Solution();
        int[] s = new int[]{3};
        int[] result = solution.resolve(s);
        System.out.println(Arrays.toString(result));
    }
}
