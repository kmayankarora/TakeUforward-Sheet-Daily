/*
    Given the root of a Binary Search Tree and an integer k,
    return true if there exist two elements in the BST such that their sum is equal to k, or false otherwise.


*/

package Day7.code;
import java.util.*;

public class Two_Sum_In_BST {    
    
    public static void main(String[] args) {
        int arr[] = {7, 3, 1, 6, 8, 2, 5, 4};
        BinarySearchTree tree = new BinarySearchTree();
        for(int i : arr) {
            tree.addNode(i);
        }
        ArrayList<Integer> inOrder = tree.getInOrder();
        for(int i : inOrder) {
            System.out.print(i + " ");
        }
    }
}

class Node{
    public int val;
    public Node left;
    public Node right;
    public Node (int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class BinarySearchTree {

    public Node root;
    
    public BinarySearchTree() { }

    public boolean isTwoSumPossible(int target) {
        // Approach 1: get InOrder sequence and run two sum with start and end pointer as InOrder is sorted in case of BST.
        // Appraoch 2: Using BST Iterator (works like start and end pointer). Create a class such that
            // This BSTIterator class allows one to access the next and previous elements (in order predecessor and successor) in a BST.
            // Initialise pointers 'i' and 'j' to the first and last elements of the BST's inorder traversal, respectively.
            //  These pointers are navigated through the BST using the next() and before() functions of the BSTIterator. 
            
        

        return true;
    }

    public void addNode(int x) {
        Node temp = root;

        if (temp == null) {
            root = new Node(x);
            return;
        }

        Node prev = null;
        while(true) {
            if (temp == null) break;
            prev = temp;
            if (temp.val > x) {
                temp = temp.left;
            } else if (temp.val < x) {
                temp = temp.right;
            } 
        }
        temp = new Node(x);
        if (prev.val < x) {
            prev.right = temp;
        } else {
            prev.left = temp;
        }
    }

    private void doInOrderTraversal(Node temp, List<Integer> lst) {
        if (temp == null) return;
        doInOrderTraversal(temp.left, lst);
        //System.out.print(temp.val +  " ");
        lst.add(temp.val);
        doInOrderTraversal(temp.right, lst);
    }

    public ArrayList<Integer> getInOrder() {
        ArrayList<Integer> lst = new ArrayList<>();
        doInOrderTraversal(root, lst);
        return lst;
    }
}

class BSTIterator {
    
}