// Problem: Reverse a Singly Linked List (Recursive)

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Solution {

    // Brute Force (Recursive):
    // - Store values using recursion
    // - Rewrite values in reverse order using recursion
    // Time: O(n), Space: O(n) recursion + O(n) list
    public Node brute(Node head) {
        if (head == null) return null;

        java.util.ArrayList<Integer> list = new java.util.ArrayList<>();
        collect(head, list); // collect values

        Node temp = head;
        int idx = list.size() - 1;

        while (temp != null) {
            temp.data = list.get(idx--);
            temp = temp.next;
        }

        return head;
    }

    private void collect(Node node, java.util.ArrayList<Integer> list) {
        if (node == null) return;
        list.add(node.data);
        collect(node.next, list);
    }

    // Better (Recursive):
    // - Use recursion to push values onto stack
    // - Pop values to rewrite nodes
    // Time: O(n), Space: O(n)
    public Node better(Node head) {
        if (head == null) return null;

        java.util.Stack<Integer> stack = new java.util.Stack<>();
        fillStack(head, stack);

        Node temp = head;
        while (temp != null) {
            temp.data = stack.pop();
            temp = temp.next;
        }

        return head;
    }

    private void fillStack(Node node, java.util.Stack<Integer> stack) {
        if (node == null) return;
        stack.push(node.data);
        fillStack(node.next, stack);
    }

    // Optimal (Recursive):
    // - Reverse pointers using recursion
    // - Base case: if head is null or head.next is null → return head
    // - Recursively reverse rest of list
    // - Fix pointers: head.next.next = head, head.next = null
    // Time: O(n), Space: O(n) recursion stack
    public Node optimal(Node head) {
        if (head == null || head.next == null) return head;

        Node newHead = optimal(head.next); // reverse rest

        head.next.next = head; // fix pointer
        head.next = null;      // break original link

        return newHead;
    }
}
