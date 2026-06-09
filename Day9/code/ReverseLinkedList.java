package Day9.code;

public class ReverseLinkedList {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 4, 8, 6, 2};

        LinkedList ll = new LinkedList();
        for(int i : arr) {
            ll.add(i);
        }

        System.out.println(ll.getList());
        ll.reverse();
        System.out.println(ll.getList());
        ll.reverseRecursively();
        System.out.println(ll.getList());
        
    }
}



