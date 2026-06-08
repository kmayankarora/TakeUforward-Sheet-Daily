/*
Statement:
You are given an array of prices where prices[i] is the price of a given stock on an ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note: That buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
*/

package Day2.code;


class stock_buy_and_sell {

    private int getMaxProfit(int[] prices) {
        int currMinPrice = prices[0];
        int maxProfit = 0;
        int len = prices.length;
        for(int i = 1; i < len; i++) {
            if (currMinPrice > prices[i]) currMinPrice = prices[i];
            maxProfit = maxProfit < (prices[i] - currMinPrice) ? (prices[i] - currMinPrice) : maxProfit;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        
        int[][] prices = {{7,1,5,3,6,4}, {7,6,4,3,1}};
        stock_buy_and_sell obj = new stock_buy_and_sell();
        int res = obj.getMaxProfit(prices[1]);
        System.out.println(res);
    }
}