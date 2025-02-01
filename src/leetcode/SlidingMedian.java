package leetcode;
// https://leetcode.com/problems/sliding-window-median/

// [1,-4,3,6,1,7], 3 -> [1,3,3,6]

// свойства:
// 1. если найти медиану всего массива, в каждом окне можно исключать эти элементы
// 2.
//1. В лоб: проходить окном, сортировать каждое окно,
// в окне искать средний/средние элементы и находить медиану, записывать в итоговый массив (длина массива n - k + 1)
// сложность n*n*logn
// 2. Сортирнуть первое окно, следующие окна обновлять - не сортировать заново. Иметь доп массив и там сдвигать
// сложность n*k


import java.util.Arrays;

public class SlidingMedian {

    class Solution {
        public double[] medianSlidingWindow(int[] nums, int k) {
            if (k == 1) {
                return Arrays.stream(nums).asDoubleStream().toArray();
            }
            int n = nums.length;
            int resultLen = n - k + 1;
            double[] result = new double[resultLen];
            int[] window = new int[k];
            System.arraycopy(nums,0,window,0,k);
            Arrays.sort(window);
            int pos = 0;
            // 0,1,2,3
            do {
                result[pos] = findMedian(window);
                if (pos < resultLen - 1) updateWindow(window, nums[pos], nums[pos+k]);
                pos++;
            } while(pos < resultLen);
            return result;
        }

        double findMedian(int[] window) {
            int n = window.length;
            if (n%2 == 1) {
                // 0,1,2
                return window[n/2];
            }
            // 0,1,2,3
            return ((double)window[n/2]+window[n/2-1])/2;
        }

        //1,2,3,4,5,6 -> 2 7
        void updateWindow(int[] window, int remove, int add) {
            if (remove != add) {
                int len = window.length;
                boolean removed = false;
                if (remove < add) {
                    for (int i = 0; i < len; i++) {
                        if (window[i] == remove) {
                            removed = true;
                            continue;
                        }
                        if (window[i] < add && removed) {
                            window[i-1] = window[i];
                            continue;
                        }
                        if (window[i] >= add) {
                            window[i-1] = add;
                            return;
                        }
                    }
                    window[len-1] = add;
                } else {
                    for (int i = len-1; i >= 0; i--) {
                        if (window[i] == remove) {
                            removed = true;
                            continue;
                        }
                        if (window[i] > add && removed) {
                            window[i+1] = window[i];
                            continue;
                        }
                        if (window[i] <= add) {
                            window[i+1] = add;
                            return;
                        }
                    }
                    window[0] = add;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new SlidingMedian().new Solution();
        int[] nums = new int[]{2147483647,1,2,3,4,5,6,7,2147483647};
        int target = 2;
        double[] result = solution.medianSlidingWindow(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
