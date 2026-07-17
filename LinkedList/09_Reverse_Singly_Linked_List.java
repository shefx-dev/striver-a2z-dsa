// Problem: Reverse a Singly Linked List

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Solution {

    // Brute Force:
    // - Store all values in an array/list
    // - Traverse again and rewrite values in reverse order
    // Time: O(n), Space: O(n)
    public Node brute(Node head) {
        if (head == null) return null;

        java.util.ArrayList<Integer> list = new java.util.ArrayList<>();
        Node temp = head;

        // Store values
        while (temp != null) {
            list.add(temp.data);
            temp = temp.next;
        }

        // Rewrite values in reverse
        temp = head;
        int idx = list.size() - 1;

        while (temp != null) {
            temp.data = list.get(idx--);
            temp = temp.next;
        }

        return head;
    }

    // Better:
    // - Use a stack to reverse order
    // - Pop values and rewrite nodes
    // Time: O(n), Space: O(n)
    public Node better(Node head) {
        if (head == null) return null;

        java.util.Stack<Integer> stack = new java.util.Stack<>();
        Node temp = head;

        while (temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            temp.data = stack.pop();
            temp = temp.next;
        }

        return head;
    }

    // Optimal:
    // - Reverse pointers directly
    // - Maintain prev, curr, next
    // Time: O(n), Space: O(1)
    public Node optimal(Node head) {
        if (head == null) return null;

        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node nextNode = curr.next; // store next
            curr.next = prev;          // reverse pointer
            prev = curr;               // move prev
            curr = nextNode;           // move curr
        }

        return prev; // new head
    }
}
