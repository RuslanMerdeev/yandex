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
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Sum4 {

    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
            int len = nums.length;
            if (len < 4) return result;
            List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
//            numsList = sort(numsList);
//            numsList = trim(numsList, target);
//            int size = numsList.size();
//            if (size < 4) return result;

            // 6
            // 0,1,2,3
            // 0,1,2,4
            // 0,1,2,5
            // 0,1,3,4
            // 0,1,3,5
            //...
            // 2,3,4,5

            for (int i = 0; i < numsList.size() - 3; i++) {
                for (int j = i + 1; j < numsList.size() - 2; j++) {
                    for (int k = j + 1; k < numsList.size() - 1; k++) {
                        for (int l = k + 1; l < numsList.size(); l++) {
                            int sum = numsList.get(i) + numsList.get(j) + numsList.get(k) + numsList.get(l);
                            if (sum == target) {
                                List<Integer> quad = sort(new ArrayList<>(Arrays.asList(numsList.get(i), numsList.get(j), numsList.get(k), numsList.get(l))));
                                if (!result.contains(quad)) result.add(quad);
                            }
                        }
                    }
                }
            }
            return result;
        }

        List<Integer> sort(List<Integer> list) {
            int len = list.size();
            if (len == 1) return list;
            return merge(sort(list.subList(0, len / 2)), sort(list.subList(len / 2, len)));
        }

        List<Integer> merge(List<Integer> first, List<Integer> second) {
            int firstLen = first.size();
            int secondLen = second.size();
            int firstPos = 0;
            int secondPos = 0;
            List<Integer> result = new ArrayList<>();

            do {
                // [0,2] [1,3] -> 0,0 1,0 1,1, 2,1
                if (secondPos >= secondLen || firstPos < firstLen && first.get(firstPos) <= second.get(secondPos)) {
                    result.add(first.get(firstPos));
                    firstPos++;
                } else {
                    result.add(second.get(secondPos));
                    secondPos++;
                }
            } while (firstPos < firstLen || secondPos < secondLen);
            return result;
        }

        List<Integer> trim(List<Integer> list, int target) {
            List<Integer> result = new ArrayList<>();
            for (int num : list) {
                if (num < target) {
                    result.add(num);
                }
            }
            return result;
        }
    }



    public static void main(String[] args) {
        Solution solution = new Sum4().new Solution();
        int[] nums = new int[]{2,2,2,2,2};
        int target = 8;
        List<List<Integer>> result = solution.fourSum(nums, target);
        System.out.println(result);
    }
}
