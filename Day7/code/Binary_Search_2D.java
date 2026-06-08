// Search in a sorted 2D matrix
/*
You have been given a 2-D array 'mat' of size 'N x M' where 'N' and 'M' denote the number of rows and columns, respectively.
The elements of each row are sorted in non-decreasing order. Moreover, the first element of a row is greater than the last element of the previous row
(if it exists). You are given an integer ‘target’, and your task is to find if it exists in the given 'mat' or not
*/

package Day7.code;

class Binary_Search_2D {

    private boolean searchViaBinarySearchIn2D(int[][] arr, int target) {
        int searchPotentialRow = 0;
        int startRow = 0, endRow = arr.length - 1;
        while(true) {
            if (arr[endRow][0] < target) {
                searchPotentialRow = endRow;
                break;
            }
            searchPotentialRow = (startRow + endRow) / 2;
            if (arr[searchPotentialRow][0] > target) endRow = searchPotentialRow - 1;
            else if (arr[searchPotentialRow][0] < target) startRow = searchPotentialRow;
        }
        
    }

    public static void main(String[] args) {

    }
}
