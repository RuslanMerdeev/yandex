package leetcode;
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

// [],any -> 0
// [2],any -> 0
// [2,5],2 -> 3
// [2,2],2 -> 0 ничего не делали
// [2,4],2 -> 0 можно сделать но ничего не будем делать
// [2,5],2 -> 3
// [2,4,5,7,5,7,8,9,2],2 -> 5 \\ 3 + 2
// [ 2, 4, 5, 5, 5, 2, 2, 9, 2],2 -> 5 \\ 3 + 2
// [ 0, 2, 3, 0, 0,-3, 0, 7,-7] diff
// [2,4,5,7,5,5,5,5,5,7,8,9,2],2 -> 5 \\ 3 + 2
// [2,4,5,7,5,7,8,9],2 -> 5 \\ 3 + 2
// [7,2,5,7,5,7,8,9],2 -> 5 \\ 3 + 2
// [2,4,5,7,6,5,4,3,2],2 -> 5 \\ 3 + 2
// [2,4,5,7,6,6,6,6,6,7,8,9,2],2 -> 5 \\ 3 + 1
// [2,7, 6,9]
// [0,5,-1,3] diff



// (end-start-fee) > 0
// по сути мы должны отфильтровать перепады в fee
// искать экстремумы с учетом фильтра
// покупать на минимуме продавать на след максимуме. Фиксить результат на максимуме

//свойства
// max diff = [+0, -] если макс падает > fee - фиксировать и (end-start-fee) > 0
// min diff = [-0, +]


public class MaxProfitWithFee {

    class Solution {
        public int maxProfit(int[] prices, int fee) {
            int n = prices.length;
            int result = 0;
            if (n < 2) return result;

            int prev = prices[0];
            int prevDiff = 0;
            int min = prices[0];
            int max = 0;
            int profitOnMax = 0;

            for (int i = 1; i <= n; i++) {
                int curr;
                if (i == n) {
                    curr = 0;
                } else {
                    curr = prices[i];
                }
                int diff = curr-prev;

                //min
                if (prevDiff <= 0 && diff > 0) {
                    if (max-prev <= fee) {
                        result -= profitOnMax;
                    } else {
                        min = prev;
                    }
                }

                //max
                if (prevDiff >= 0 && diff < 0) {
                    int preProfit = prev - min - fee;
                    // memorize
                    max = prev;
                    profitOnMax = preProfit;
                    result += preProfit;
                }

                prevDiff = diff;
            }

            return result;
        }
    }

    public static void main(String[] args) {
        int[] prices = new int[]{2,5};
        int fee = 2;
        int result = new MaxProfitWithFee().new Solution().maxProfit(prices,fee);
        System.out.println(result);
    }
}
