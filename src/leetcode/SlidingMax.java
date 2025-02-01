package leetcode;
// https://leetcode.com/problems/sliding-window-maximum/

// [1,-4,3,6,1,7], 3 -> [3,6,6,7]
// [1] , 1 -> [1]
// [-500, 500, 0] , 3 -> [-500, 500, 0]

//

import java.util.Arrays;

public class SlidingMax {

    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            // precheck
            int n = nums.length;
            if (k == 1) {
                return nums;
            }

            // window
            int[] window;// = Arrays.copyOfRange(nums, 0, k);

            // result
            int resultN = n - k + 1;
            int[] result = new int[resultN];
            int pos = 0;

            // computation
            do {
                window = Arrays.copyOfRange(nums, pos, pos+k);//updateWindow(window, nums[pos], nums[pos+k]);
                result[pos] = Arrays.stream(window).max().getAsInt();
                pos++;
            } while(pos < resultN);

            return result;
        }

//        updateWindow(int[] window, int toRemove, int toAdd) {
//
//        }
    }

    public static void main(String[] args) {
        Solution solution = new SlidingMax().new Solution();
        int[] nums = new int[]{2147483647,1,2,3,4,5,6,7,2147483647};
        int target = 2;
        int[] result = solution.maxSlidingWindow(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
