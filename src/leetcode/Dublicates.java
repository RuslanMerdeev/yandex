package leetcode;

public class Dublicates {

    class Solution {
        public int removeDuplicates(int[] nums) {
            int current = nums[0];
            int have = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != current) {
                    nums[have] = nums[i];
                    have++;
                    current = nums[i];
                }
            }
            return have;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Dublicates().new Solution();
        int[] ints = {0, 1, 1, 2, 3, 3, 4, 6};
        int i = solution.removeDuplicates(ints);
        System.out.println(i);
    }
}
