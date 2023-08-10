package leetcode;

public class MajorityElement {
    class Solution {
        public int majorityElement(int[] nums) {
            int count = 0;
            int candidate = nums[0];
            for (int i = 0; i < nums.length; i++) {
                if (count == 0) {
                    candidate = nums[i];
                }
                count += (nums[i] == candidate) ? 1 : -1;
            }
            return candidate;
        }
    }

    public static void main(String[] args) {
        Solution solution = new MajorityElement().new Solution();
        int element = solution.majorityElement(new int[]{2, 3, 2, 3, 2, 3, 2});
        System.out.println(element);
    }
}
