## stock buy and sell - Day 2 #easy

##### Problem statement
link: https://takeuforward.org/data-structure/stock-buy-and-sell
- You are given an array of prices where `prices[i]` is the price of a given stock on an `i-th` day. You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
- Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

- Examples
    - Input: prices = [7,1,5,3,6,4]
    - Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
    - Note: That buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

    - Input: prices = [7,6,4,3,1]
    - Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
---

##### Solution:
The idea is to <u>track the minimum price so far while traversing the array and calculate the profit if we sold today.</u> This way, we can constantly update the maximum profit without using nested loops.

```java
````