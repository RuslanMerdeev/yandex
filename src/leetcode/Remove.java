package leetcode;

public class Remove {

    class Solution {
        public int removeElement(int[] nums, int val) {
            int removed = 0;
            int size = nums.length;
            for (int i = size-1; i >= 0; i--) {
                if (nums[i] == val) {
                    nums[i] = nums[size-1-removed];
                    removed++;
                }
            }
            return size-removed;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Remove().new Solution();
        int[] nums = {0, 3, 4, 6, 2, 4};
        int i = solution.removeElement(nums, 4);
        System.out.println(i);
    }
}
