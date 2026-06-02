## Pascal Triangle problem - Day 1

#### Problem link: https://takeuforward.org/data-structure/program-to-generate-pascals-triangle #easy
---

pascal triangle example
- n = 4:
    -  [1; 1 1; 1 2 1; 1 3 3 1] 
- n = 6:
    - [1; 1 1; 1 2 1; 1 3 3 1; 1 4 6 4 1; 1 5 10 10 5 1]

#### Code:
```java
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
```

To find out a value at a specific row, use the binomial coefficient formaula: 

$$
\binom{n}{r} = \frac{n!}{(n-r)! \cdot r!}
$$

