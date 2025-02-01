package leetcode;
// https://leetcode.com/problems/4sum/

// [1], 1 -> null
// [1,2], 1 -> null
// [1,2,3], 1 -> null
// [1,2,3,4], 10 -> [1,2,3,4]
// [0,1,2,3,4], 10 -> [1,2,3,4]
// [0,1,2,3,4,5], 10 -> [1,2,3,4],[0,2,3,5]
// [4,5,2,2,7,9,1,1,0,0,3], 13 -> [1,2,3,4],[0,2,3,5]


//1. рекурсия: продумать
//2. n^4: пробег по всем вариантам с накоплением в листе
//3. сортировка: нужна реализация сортировки (merge) + тк минусов нет, то решение лежит между 1 и 10. Можно пробегом найти там

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum4 {

    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            int len = nums.length;
            if (len < 4) return result;

            for (int i = 0; i < len - 3; i++) {
                for (int j = i + 1; j < len - 2; j++) {
                    long semiSum = nums[i]+nums[j];
                    int left = j+1;
                    int right = len-1;
                    do {
                        long currSum = nums[left]+nums[right];
                        if (currSum+semiSum == target) {
                            List<Integer> quad = Arrays.asList(nums[i], nums[j], nums[left], nums[right]);
                            if (!result.contains(quad)) {
                                result.add(quad);
                            }
                            right--;
                            left++;
                        } else if (currSum+semiSum > target) {
                            right--;
                        } else {
                            left++;
                        }
                    } while(right>left);
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Sum4().new Solution();
        int[] nums = new int[]{1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;
        List<List<Integer>> result = solution.fourSum(nums, target);
        System.out.println(result);
    }
}
