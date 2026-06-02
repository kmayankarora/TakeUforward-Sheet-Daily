## Kadane's Algo: Maximum SubArray Sum - Day 2

#### Problem link: https://takeuforward.org/data-structure/kadanes-algorithm-maximum-subarray-sum-in-an-array #easy
---

-  nums = [2, 3, 5, -2, 7, -4] 
    - Output = 15
- nums = [-2, -3, -7, -2, -10, -4] 
    - Output = -2

---
1. Kadane's Algo
    1.  Iterate through the array using a variable `i`. During each iteration, add the current element `arr[i]` to a running sum variable.
    2.  Keep track of the maximum sum encountered during the iteration by comparing the current sum with the previous maximum sum, and update it if the current sum is greater.
    3. ⭐ If at any point the sum becomes negative, reset it to 0, <u> as a negative sum won't contribute positively to the overall maximum sum </u>.
    4. Continue the iteration until all elements in the array are processed.

    ```java
    private int getMaxSubArraySum(int[] arr) {
        int len = arr.length;
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i = 0 ; i < len; i++) {
            currSum += arr[i];
            if (currSum > maxSum) maxSum = currSum;
            if (currSum < 0) currSum = 0;
        }
        return maxSum;
    }

    // input: [2, 3, -2, 7, -4]  => output = 10 i.e. [2, 3, -2, 7]
    // logic is simple. keep on adding and updating the curr Sum until we hit the sum as negative.
    /*
        maxSum = -Inf
        currSum = 0;
        i = 0       |  currSum = 2 => currSum > maxSum => maxSum = currSum = 2;
        i = 1       |  currSum = 5 => currSum > maxSum => maxSum = currSum = 5;
        i = 2       |  currSum = 3 => maxSum = 5 but currSum = 3;
        i = 3       |  currSum = 10 => currSum (10) > maxSum (5) => maxSum = currSum;
        i = 4       |  currSum = 6 => maxSum = 10 but currSum = 6;
    */
    
    ```

