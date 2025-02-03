package leetcode;
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

// [] -> 0
// [1] -> 0
// [1,2] -> 1
// [2,1,1,1] -> 0
// [1,1,1,2] -> 1
// [1,1,1,2,1,1] -> 1
// [1, 2, 3, 2, 1, 4, 1] -> 3
//   [ 1, 1,-1,-1, 3,-3]
// [1, 1, 2, 2, 1, 1, 2] -> 1
//   [ 0, 1, 0,-1, 0, 1]


// properties:
// need min
// then need max after min

// var for min = prices[0]
// var for max

// нашли max - сохр в max(если бьет предыдущее) и в result = max-min
// нашли мин - сохр в мин(если бьет предыдущее)

// max - diff[+ -> -0]
// min - diff[- -> +0]

public class MaxProfit {

    class Solution {
        public int maxProfit(int[] prices) {
            int len = prices.length;
            if (len < 2) return 0;

            int min = prices[0];
            int max = 0;
            int prev = prices[0];
            int prevDiff = 0;
            int result = 0;

            for (int i = 1; i <= len; i++) {
                int curr = 0;
                if (i < len) {
                    curr = prices[i];
                }
                int currDiff = curr-prev;

                //min
                if (prevDiff < 0 && currDiff >= 0) {
                    if (prev < min) {
                        min = prev;
                    }
                }

                //max
                if (prevDiff > 0 && currDiff <= 0) {
                        int preResult = prev - min;
                        if (preResult > result) {
                            result = preResult;
                        }
                }

                prev = curr;
                prevDiff = currDiff;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1, 1, 2, 2, 1, 1, 3};
        int result = new MaxProfit().new Solution().maxProfit(prices);
        System.out.println(result);
    }
}
