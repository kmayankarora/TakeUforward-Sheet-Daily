public class Day1_set_matrix_zeroes {

    private void printMatrix(int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++)      
                System.out.print(arr[i][j]);
            System.out.println();
        }
    }

    private void printMatrix(boolean[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }
    
    private void modifyMatrix(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;

        boolean[] row_flag_array = new boolean[rows];
        boolean[] col_flag_array = new boolean[cols]; 

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                // System.out.print(arr[i][j]);
                if (arr[i][j] == 0) {
                    row_flag_array[i] = true;
                    col_flag_array[j] = true;
                }
            }
            // System.out.println();
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
    
    public static void main(String[] args) {
        Day1_set_matrix_zeroes obj = new Day1_set_matrix_zeroes();

        int[][] arr = new int[][] {{1,1,1}, {1,0,1}, {1,1,1}}; 
        int[][] arr2 = new int[][] {{0,1,2,0}, {3,4,5,2}, {1,3,1,5}};

        obj.modifyMatrix(arr2);
        obj.printMatrix(arr2);

    }    
}
