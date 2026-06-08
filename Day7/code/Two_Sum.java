/*
Given an array of integers arr[] and an integer target.

Return indices of the two numbers such that their sum is equal to the target. Otherwise, we will return {-1, -1}.
*/

package Day7.code;

import java.util.Arrays;
import java.util.HashMap;

public class Two_Sum {
    
    private int [] getTwoSumPairUsingHashing(int arr[], int targetSum) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int len = arr.length;
        for(int i = 0; i < len; i++) {
            if (map.containsKey(targetSum - arr[i])) {
                int otherIndex = map.get(targetSum - arr[i]);
                return new int[] { otherIndex , i};
            } else {
                map.put(arr[i], i);
            }
        }
        return new int[]{-1, -1};
    }
    private int[] getTwoSumPairUsingSort(int arr[], int targetSum) {

        int len = arr.length;
        int[][] indexArray = new int[len][2];
        for(int i = 0; i < len; i++) {
            indexArray[i][0] = arr[i];
            indexArray[i][1] = i;
        }


        Arrays.sort(indexArray, (a, b) -> a[0] - b[0]);
        int front = 0, end = len - 1;

        while (front < end) {
            if (indexArray[front][0] + indexArray[end][0] < targetSum) {
                front++;
            } else if (indexArray[front][0] + indexArray[end][0] > targetSum) {
                end--;
            } else {
                return new int[] {indexArray[front][1], indexArray[end][1]};
            }
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[] target = {14, 15};
        int[][] arr = {{2,6,5,8,11}, {2,6,5,8,11}};

        Two_Sum obj = new Two_Sum();

        int currentRun = 0;
        int[] pair1 = obj.getTwoSumPairUsingHashing(arr[currentRun], target[currentRun]);
        System.out.println(pair1[0] + " " + pair1[1]);

        int[] pair2 = obj.getTwoSumPairUsingSort(arr[currentRun], target[currentRun]);
        System.out.println(pair2[0] + " " + pair2[1]);
    }
}
