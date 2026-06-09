package Day9.code;

public class MergeSortedLinkedList {
    
    public static void main(String[] args) {
        int[][] arr = {{1, 3, 5, 15}, {0, 2, 4, 6, 8, 10, 12}};

        LinkedList ll1 = new LinkedList();
        LinkedList ll2 = new LinkedList();
        for(int i : arr[0]) {
            ll1.add(i);
        }
        for(int i : arr[1]) {
            ll2.add(i);
        }

        ll1.mergeWithSortedLinkedList(ll2);
        System.out.println(ll2.getList());

        System.out.println(ll1.getMiddleNode().val);
    }
}
