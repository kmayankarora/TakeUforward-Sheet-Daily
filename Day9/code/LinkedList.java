package Day9.code;
import java.util.ArrayList;

class Node {
    public int val;
    public Node next;
    public Node(int x) {
        val = x;
        next = null;
    }
}

public class LinkedList {
    private Node head, tail;
    public LinkedList() {
        head = null;
        tail = null;
    }
    public void add(int x) {
        Node newnode = new Node(x);
        if (tail == null || head == null) {
            head = newnode;
            tail = head;
            return;
        } 
        tail.next = newnode;
        tail = newnode;
    }

    public ArrayList<Integer> getList() {
        ArrayList<Integer> lst = new ArrayList<>();
        Node temp = head;
        while(temp != null) {
            lst.add(temp.val);
            temp = temp.next;
        }
        return lst;
    }

    public void reverse() {
        this.tail = head;
        Node prev = null, nextNode = null, curr = head;
        while(curr != null) {
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        this.head = prev;
    }

    public void reverseRecursively() {
        tail = head;
        head = reverseRecursively(null, head);
    }
    private Node reverseRecursively(Node prev, Node curr) {
        if (curr == null) return prev;

        Node nextNode = curr.next;
        curr.next = prev;
        return reverseRecursively(curr, nextNode);
    }

    public Node getMiddleNode() {
        Node slow = head, fastNode = head;
        Node temp = null;
        while(fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slow = slow.next;
        }
        return slow;
    }   

    public void mergeWithSortedLinkedList(LinkedList lst2) {
        Node temp1 = head;
        Node temp2 = lst2.head;

        Node newHead = null, newTail = null;

        if (temp1 == null) {
            newHead = lst2.head;
            newTail = lst2.tail;
        } else if (temp2 == null) {
            newHead = head;
            newTail = tail;
        } else {
            if (temp1.val < temp2.val) {
                newHead = temp1;
                temp1 = temp1.next;
            } else {
                newHead = temp2;
                temp2 = temp2.next;
            }
            Node tempNode = newHead;
            while(temp1 != null && temp2 != null) {
                if (temp1.val < temp2.val) {
                    tempNode.next = temp1;
                    tempNode = temp1;
                    temp1 = temp1.next;
                } else {
                    tempNode.next = temp2;
                    tempNode = temp2;
                    temp2 = temp2.next;
                }
            }

            if (temp1 == null) {
                tempNode.next = temp2;
                newTail = lst2.tail;
            } else {
                tempNode.next = temp1;
                newTail = tail;
            }

        }
        this.head = newHead;
        this.tail = newTail;
        lst2.head = newHead;
        lst2.tail = newTail;
    }
}