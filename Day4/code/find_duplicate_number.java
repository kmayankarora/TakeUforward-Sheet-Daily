// Find the duplicate in an array of N+1 integers

// Given an array of N + 1 size, where each element is between 1 and N.
// Assuming there is only one duplicate number, your task is to find the duplicate number.

package Day4.code;

class find_duplicate_number {
    
    private int findDuplicateNumber(int[] arr) {
        int n_plus_1 = arr.length;
        int len = arr.length;
        int sum =  len * (len + 1) / 2;

        int cummSum = 0;
        for (int a : arr) {
            cummSum += a;
        }

        int diff = sum - cummSum;
        return n_plus_1 - diff;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3, 4, 2, 2}, {3, 1, 3, 4, 2}};
        
        find_duplicate_number obj = new find_duplicate_number();
        for(int i = 0; i < arr.length; i++) {
            System.out.println(obj.findDuplicateNumber(arr[i]));
        }
    }
}