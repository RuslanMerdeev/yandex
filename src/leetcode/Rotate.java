package leetcode;

public class Rotate {
    class Solution {
        public void rotate(int[] nums, int k) {
            k %= nums.length;
            reverse(nums, 0, nums.length-1);
            reverse(nums, 0, k-1);
            reverse(nums, k, nums.length-1);
        }

        void reverse(int[] nums, int start, int end) {
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Rotate().new Solution();
        int[] nums = {0, 1, 2, 3, 4, 5, 6};
        solution.rotate(nums, 0);
        System.out.println("done");
    }
}
