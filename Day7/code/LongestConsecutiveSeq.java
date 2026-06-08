/*
Problem Statement: Given an array nums of n integers.
Return the length of the longest sequence of consecutive integers. The integers in this sequence can appear in any order.

Input: nums = [100, 4, 200, 1, 3, 2, 2] => Output = 4 
the longest consecutive sequence is [1,2,3,4]
*/

package Day7.code;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSeq {
    
    private int getLongestConsecutiveSeqLength(int arr[]) {
        Arrays.sort(arr);

        int currentCount = 1, maxLength = 0;
        int len = arr.length;
        for(int i=1; i < len; i++) {
            if (arr[i] == arr[i-1] + 1) {
                currentCount++;
            } else if (arr[i] != arr[i-1]) {
                if (maxLength < currentCount) maxLength = currentCount;
                currentCount = 1;
            }
        }
        if (maxLength < currentCount) maxLength = currentCount;
        return maxLength;
    }

    private int getLongestConsecutiveSeqLength2(int arr[]) {
        HashSet<Integer> set = new HashSet<>();

        int len = arr.length;
        for(int i = 0; i < len; i++) {
            set.add(arr[i]);
        }

        int currentCount = 1, maxLength = 0;
        for(int itr : set) {
             // If there is no number before 'it', it’s the start of a sequence
            if (! set.contains(itr - 1)) {
                currentCount = 1;
                
                int currentNum = itr;
                while(set.contains(currentNum + 1)) {
                    currentCount++;
                    currentNum++;
                }
                if (maxLength < currentCount) maxLength = currentCount;
            } 
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestConsecutiveSeq obj = new LongestConsecutiveSeq();

        int[][] arr = {{100, 4, 200, 1, 3, 2, 2}, {0, 3, 7, 2, 5, 8, 4, 6, 0, 1}};
        int[] expectedOutput = {4, 9};

        int currentRunIndex = 0;
        int res = obj.getLongestConsecutiveSeqLength(arr[currentRunIndex]);
        System.out.println(res);

        int res2 = obj.getLongestConsecutiveSeqLength2(arr[currentRunIndex]);
        System.out.println(res2);
    }
}
