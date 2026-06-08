package Day3.code;

import java.util.*;

/*
Statement: Given an array of intervals where intervals[i] = [starti, endi],
merge all overlapping intervals and return an array of the non-overlapping intervals
that cover all the intervals in the input.

Input : intervals=[[1,3],[2,6],[8,10],[15,18]]
Output : [[1,6],[8,10],[15,18]]

Input : [[1,4],[4,5]]
Output :  [[1,5]]

*/

class merge_overlapping_subintervals {
    
    public void overlapIntervals(int[][] intervals, List<List<Integer>> res) {

        // sorting them ascending order
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int n = intervals.length;
        
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3}, {2,6}, {8,10}, {15,18}};
        List<List<Integer>> result = new ArrayList<>();

        merge_overlapping_subintervals obj = new merge_overlapping_subintervals();
        obj.overlapIntervals(intervals, result);
    }
}