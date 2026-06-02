package Day2.code;

// Kadane's Algorithm : Maximum Subarray Sum in an Array

// input: [2, 3, -2, 7, -4]  => output = 10 i.e. [2, 3, -2, 7]

// logic is simple. keep on adding and updating the max value untill we hit the sum as negative.
/*
    DRY RUN:
    maxSum = -Inf
    currSum = 0;
    i = 0       |  currSum = 2 => currSum > maxSum => maxSum = currSum = 2;
    i = 1       |  currSum = 5 => currSum > maxSum => maxSum = currSum = 5;
    i = 2       |  currSum = 3 => maxSum = 5 but currSum = 3;
    i = 3       |  currSum = 10 => currSum (10) > maxSum (5) => maxSum = currSum;
    i = 4       |  currSum = 6 => maxSum = 10 but currSum = 6;
*/


class Kadane_algo {
    
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
    
    public static void main(String[] args) {
        Kadane_algo obj = new Kadane_algo();
        int[] arr = {-2, -3, -7, -2, -10, -4, -1} ;
        int maxi = obj.getMaxSubArraySum(arr);
        System.out.println(maxi);
    }
}