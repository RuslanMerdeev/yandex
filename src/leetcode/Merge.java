package leetcode;

import java.util.Arrays;
import java.util.List;

public class Merge {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            while(m > 0 || n > 0) {
                if (m > 0 && n > 0) {
                    if (nums1[m-1] > nums2[n-1]) {
                        nums1[m+n-1] = nums1[--m];
                    } else {
                        nums1[m+n-1] = nums2[--n];
                    }
                } else if (m > 0) {
                    nums1[m+n-1] = nums1[--m];
                } else {
                    nums1[m+n-1] = nums2[--n];
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Merge().new Solution();
        int[] nums1 = {0, 0, 2, 3, 0, 0, 0, 0, 0};
        solution.merge(nums1, 4, new int[] {1, 3, 4, 5, 9}, 5);
        System.out.println(List.of(nums1));
    }
}
