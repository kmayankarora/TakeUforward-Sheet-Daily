import java.util.ArrayList;

public class Day1_pascal_triangle {

    public void printPascalTriangle(ArrayList<Integer> lst) {
        int len = lst.size();
        int line_size = 1;
        int count = 0;
        for(int i = 1; i <= len; i++) {
            System.out.print(lst.get(i-1));
            count++;
            if (count == line_size) {
                System.out.println();
                line_size++;
                count = 0;
            }
        }
    }
    
    public void generatePascalTriangle(int n) {
        
        ArrayList<Integer> lst = new ArrayList<>();
        lst.add(1);

        for(int i = 2; i <= n; i++) {

            // finding the index of last generated row
            int currLen = lst.size();
            int end_index = currLen -1;
            int start_index = end_index - i + 2;

            for(int j = 0; j < i; j++) {
                if (j == 0 || j == i-1)
                    lst.add(1);
                else {
                    lst.add(lst.get(start_index) + lst.get(start_index + 1));
                    start_index++;
                }
            }
        }

        printPascalTriangle(lst);
    }

    public static void main(String[] args) {
        Day1_pascal_triangle obj = new Day1_pascal_triangle();
        obj.generatePascalTriangle(7);
    }
}