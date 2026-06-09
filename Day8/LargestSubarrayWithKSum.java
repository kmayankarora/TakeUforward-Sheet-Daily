// Given an array containing both positive and negative integers, we have to find the length of the longest subarray with the sum of all elements equal to zero.
// N = 6, array[] = {9, -3, 3, -1, 6, -5}  => Result = 5
// Explanation:  The following subarrays sum to zero: {-3, 3}, {-1, 6, -5}, {-3, 3, -1, 6, -5}

package Day8;

import java.util.*;

public class LargestSubarrayWithKSum {

    // Brute Force
    private int getLargestSubarrayWithKSum(int[] arr, int target) {
        int first = 0, second = 1;
        int len = arr.length;
        List<List<Integer>> lst = new ArrayList<>();

        for(first = 0; first < len; first++) {
            int runningSum = 0;
            for(second = first; second < len; second++) {
                runningSum += arr[second];
                if (runningSum == target) {
                    List<Integer> indexes = Arrays.asList(first, second);
                    lst.add(indexes);
                }
            }
        }

        int length = 0;
        for(List<Integer> ls : lst) {
            System.out.println("indexes are " + ls.get(0) + " : " + ls.get(1));
            int curLen = ls.get(1).intValue() - ls.get(0).intValue() + 1;
            if (length < curLen) length = curLen;
        }
        return length;
    }

    // Better approach: Start adding the numbers, if the same sum is coming again, it means the net increment was none (for target = 0)
    private int getLargestSubarrayWithKSum2(int[] arr, int target) {

        int runnSum = 0;
        int len = arr.length;
        List<List<Integer>> lst = new ArrayList<>();
        HashMap<Integer, Integer> mymap = new HashMap<>();

        for(int i = 0; i < len; i++) {
            runnSum += arr[i];


            if (runnSum == target) {
                List<Integer> indexes = Arrays.asList(0, i);
                lst.add(indexes);
            } 
            if (mymap.containsKey(runnSum - target)) {
                List<Integer> indexes = Arrays.asList(mymap.get(runnSum - target), i);
                lst.add(indexes);
            } 
            if (!mymap.containsKey(runnSum))
                mymap.put(runnSum, i);
        }

        int length = 0;
        for(List<Integer> ls : lst) {
            System.out.println("indexes are " + ls.get(0) + " : " + ls.get(1));
            int curLen = ls.get(1).intValue() - ls.get(0).intValue() + 1;
            if (length < curLen) length = curLen;
        }
        return length;

    }

    private int getLargestSubarrayWithKSum3(int[] arr, int target) {
        
    }


    public static void main(String[] args) {
        
        LargestSubarrayWithKSum obj = new LargestSubarrayWithKSum();

        int[][] arr = {{9, -3, 3, -1, 6, -5}, {6, -2, 2, -8, 1, 7, 4, -10}};
        int target[] = {0, 0};

        int currRun = 1;
        int len = obj.getLargestSubarrayWithKSum(arr[currRun], target[currRun]);
        System.out.println(len);

        int len2 = obj.getLargestSubarrayWithKSum(arr[currRun], target[currRun]);
        System.out.println(len2);
    }
    
}