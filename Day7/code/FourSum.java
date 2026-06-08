// Find Quads that add up to a target value
// Given an array of N integers, your task is to find unique quads that add up to give a target value.
// In short, you need to return an array of all the unique quadruplets [arr[a], arr[b], arr[c], arr[d]] such that their sum is equal to a given target.
// 
// arr[] = [4,3,3,4,4,2,1,2,1,1], target = 9    => Result: [[1,1,3,4],[1,2,2,4],[1,2,3,3]]

package Day7.code;

import java.util.*;

public class FourSum {
    
    // Brute Force
    public List<List<Integer>> get4SumApproach1(int[] arr, int target) {
        Set<List<Integer>> myset = new HashSet<>();

        int len = arr.length;
        for(int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    for (int l = k + 1; l < len; l++) {
                        if (arr[i] + arr[j] + arr[k] + arr[l] == target) {
                            List<Integer> lst = Arrays.asList(arr[i], arr[j], arr[k], arr[l]);
                            Collections.sort(lst);
                            myset.add(lst);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(myset);
    }
    
    // Two outer loop + hashing for 3rd loop --> slightly better
    public List<List<Integer>> get4SumApproach2(int[] arr, int target) {
        Set<List<Integer>> myset = new HashSet<>();

        int len = arr.length;
        for(int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                HashSet<Integer> visited = new HashSet<>();
                for (int k = j + 1; k < len; k++) {
                    int expectedFourthElement = target - arr[i] - arr[j] - arr[k];
                    if (visited.contains(expectedFourthElement)) {
                        List<Integer> lst = Arrays.asList(arr[i], arr[j], arr[k], expectedFourthElement);
                        Collections.sort(lst);
                        myset.add(lst);
                    } else {
                        visited.add(arr[k]);
                    }
                }
            }
        }
        return new ArrayList<>(myset);
    }

    // sort the array; use two outer loop and then two pointer algo for 3rd and 4th element (basically using optimized Two-Sum)
    public List<List<Integer>> get4SumApproach3(int[] arr, int target) {
        Set<List<Integer>> myset = new HashSet<>();

        Arrays.sort(arr);

        int len = arr.length;
        for(int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                // the rest of elements are all sorted.
                int front = j + 1;
                int end = len - 1;

                int targetForTwoSum = target - arr[i] - arr[j];
                while(front < end) {
                    if (arr[front] + arr[end] < targetForTwoSum) front++;
                    else if (arr[front] + arr[end] > targetForTwoSum) end--;
                    else {
                        List<Integer> lst = Arrays.asList(arr[i], arr[j], arr[front], arr[end]); // these 4 numbers are also sorted.
                        myset.add(lst);
                        break;
                    }
                }
            }
        }
        return new ArrayList<>(myset);
    }

    private void printLists(List<List<Integer>> lst) {
        for(List<Integer> ls : lst) {
            System.out.print("[");
            for (int ele : ls) {
                System.out.print(" " + ele);
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) {

        FourSum obj = new FourSum();

        int arr[][] = {{4,3,3,4,4,2,1,2,1,1}, {1,0,-1,0,-2,2}};
        int target[] = {9, 0};

        int runIndex = 0;
        List<List<Integer>> lst1 = obj.get4SumApproach1(arr[runIndex], target[runIndex]);
        obj.printLists(lst1);
        System.out.println("---------------");

        List<List<Integer>> lst2 = obj.get4SumApproach2(arr[runIndex], target[runIndex]);
        obj.printLists(lst2);
        System.out.println("---------------");

        List<List<Integer>> lst3 = obj.get4SumApproach3(arr[runIndex], target[runIndex]);
        obj.printLists(lst3);
        System.out.println("---------------");
    }
}
