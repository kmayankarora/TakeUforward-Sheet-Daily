## Set Matrix Zeroes problem - Day 1

#### Problem link: https://takeuforward.org/data-structure/set-matrix-zero
---

Problem Statement: Given a matrix if an element in the matrix is 0 then you will have to set its entire column and row to 0 and then return the matrix.

- Input: matrix = [[[1,1,1],[1,0,1],[1,1,1]] ]
Output:  [[[1,0,1],[0,0,0],[1,0,1]] ]
Explanation: Since matrix[2][2]=0.Therfore the 2nd column and 2nd row wil be set to 0.

- Input: matrix = [[[0,1,2,0],[3,4,5,2],[1,3,1,5]]]
Output: [[[0,0,0,0],[0,4,5,0],[0,3,1,0]]]
Explanation:Since matrix[0][0]=0 and matrix[0][3]=0. Therefore 1st row, 1st column and 4th column will be set to 0

---

#### Good Approach:
Instead of marking directly in the matrix, keep two extra arrays:
- One to track which rows need to be zeroed.
- One to track which columns need to be zeroed.

When you find a zero, mark its row index in the row array and column index in the col array. After the scan, you go back and zero out all marked rows and columns. This avoids accidental over-zeroing in the first pass.
Create a row array of size m (rows) and a col array of size n (columns) initialized to false.

- First pass: Traverse the matrix, and when you find a zero:
    - Mark the corresponding row index in row array.
    - Mark the corresponding col index in col array.
- Second pass: Traverse the matrix again, and if either the row or col is marked, set the cell to zero.

```java
private void modifyMatrix(int[][] arr) {
    int rows = arr.length;
    int cols = arr[0].length;

    boolean[] row_flag_array = new boolean[rows];
    boolean[] col_flag_array = new boolean[cols]; 

    for(int i = 0; i < rows; i++) {
        for(int j = 0; j < cols; j++) {
            if (arr[i][j] == 0) {
                row_flag_array[i] = true;
                col_flag_array[j] = true;
            }
        }
    }

    // printMatrix(row_flag_array);
    // printMatrix(col_flag_array);
    
    for(int i = 0; i < rows; i++) {
        for(int j = 0; j < cols; j++) {
            if (row_flag_array[i] || col_flag_array[j]) {
                arr[i][j] = 0;
            }
        }
    }
}
```

#### Optimcal Approach
👉 Instead of using separate arrays, we use the first row and first column of the matrix itself to store whether a row or column needs to be zeroed. We also store two flags:
- firstRowZero: Was the first row supposed to be all zero?
- firstColZero: Was the first column supposed to be all zero?

Then:
- First pass: Mark zeros in the first row and column for any zero found in the rest of the matrix.
- Second pass: Use those markers to set rows and columns to zero.