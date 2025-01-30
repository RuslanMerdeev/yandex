package leetcode;
// https://leetcode.com/problems/permutation-in-string/

// [1] -> 1
// [1,1,2] -> 2
// [2, 3,3] -> 2
// [2,2,5,5,6,9,9,1,1] -> 6

public class SingleNumber {

    class Solution {

        public int singleNumber(int[] nums) {
            int result = 0;
            for (int i : nums) {
                result = result ^ i;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new SingleNumber().new Solution();
        int[] numbers = new int[]{2,2,5,5,6,9,9,1,1};
        int result = solution.singleNumber(numbers);
        System.out.println(result);
    }
}
