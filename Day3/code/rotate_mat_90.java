package Day3.code;

class rotate_mat_90 {

    private void printMatrix(int[][] mat) {
        int numRows = mat.length;
        int numCols = mat[0].length;
        for(int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

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
        //  0 <--> last;
        //  1 <--> 2nd last
        for(int j = 0; j < numCols / 2; j++) {
            for (int i = 0; i < numRows; i++) {
                int temp = mat[i][j];
                mat[i][j] = mat[i][numCols - 1 -j];
                mat[i][numCols - 1 -j] = temp;
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 1, 2}, {2, 0, 3, 1}, {4, 5, 0, 5}, {5, 6, 7, 0}};
        
        rotate_mat_90 obj = new rotate_mat_90();
        
        obj.printMatrix(matrix);
        System.out.println("----------------");
        obj.rotateBy90(matrix);
        obj.printMatrix(matrix);
    }
}