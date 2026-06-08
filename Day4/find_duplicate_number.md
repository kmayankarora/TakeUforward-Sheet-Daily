## find duplicate number - Day 4

#### Problem link: https://takeuforward.org/data-structure/find-the-duplicate-in-an-array-of-n1-integers

###### statement: Given an array of N + 1 size, where each element is between 1 and N. Assuming there is only one duplicate number, your task is to find the duplicate number.
---

```
Input:  arr = [1, 3, 4, 2, 2]   =>   Output: 2
Input:  arr = [3, 1, 3, 4, 2]   =>   Output: 3   
```

Logic: 
- Intead of `N+1`th number, there is a duplicate number.

```java
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
```