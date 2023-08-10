package leetcode;

public class TwoDublicates {

    class Solution {
        public int removeDuplicates(int[] nums) {
            int current = nums[0];
            boolean dublicate = false;
            int have = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != current || !dublicate) {
                    nums[have] = nums[i];
                    have++;
                    dublicate = nums[i] == current;
                    current = nums[i];
                } else {
                    dublicate = nums[i] == current;
                }
            }
            return have;
        }
    }

    public static void main(String[] args) {
        Solution solution = new TwoDublicates().new Solution();
        int[] ints = {0, 1, 1, 2, 2, 2, 3, 3, 4, 6};
        int i = solution.removeDuplicates(ints);
        System.out.println(i);
    }
}
