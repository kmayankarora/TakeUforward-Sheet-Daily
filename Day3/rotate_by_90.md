## Rotate by 90 - Day 3

#### Problem link: https://takeuforward.org/data-structure/rotate-image-by-90-degree #easy

###### statement: Given an N * N 2D integer matrix, rotate the matrix by 90 degrees clockwise. The rotation must be done in place, meaning the input 2D matrix must be modified directly
---

```
Input:
0 1 1 2 
2 0 3 1 
4 5 0 5 
5 6 7 0
---
Output:
5 4 2 0 
6 5 0 1 
7 0 3 1 
0 5 1 2
```

Logic: 
- Step 1: Transpose the matrix: swap elements across the diagonal. This converts rows into columns.
- Step 2: Reverse each row: this turns the new columns into the final rotated rows.

```java
private void rotateBy90(int[][] mat) {
    // Transpose
    int numRows = mat.length;
    int numCols = mat[0].length;
    for(int i = 0; i < numRows; i++) {
        for (int j = i+1; j < numCols; j++) {
            int temp = mat[i][j];
            mat[i][j] = mat[j][i];
            mat[j][i] = temp;
        }
    }

    // swapping columns:
    //  0 <--> last;      1 <--> 2nd last       and so on...
    for(int j = 0; j < numCols / 2; j++) {
        for (int i = 0; i < numRows; i++) {
            int temp = mat[i][j];
            mat[i][j] = mat[i][numCols - 1 -j];
            mat[i][numCols - 1 -j] = temp;
        }
    }
}
```

Brute-force:
- Initialize an empty matrix of the same size (n x n).
- For each element at position `(i, j)`, place it in the new matrix at position `(j, n - i - 1)`