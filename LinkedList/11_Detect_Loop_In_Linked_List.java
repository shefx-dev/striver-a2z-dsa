// Problem: Detect a Loop in a Singly Linked List

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
    // - Use a HashSet to store visited nodes
    // - If a node repeats → loop exists
    // Time: O(n), Space: O(n)
    public boolean brute(Node head) {
        java.util.HashSet<Node> set = new java.util.HashSet<>();
        Node temp = head;

        while (temp != null) {
            if (set.contains(temp)) return true;
            set.add(temp);
            temp = temp.next;
        }

        return false;
    }

    // Better:
    // - Modify node values (NOT recommended in interviews)
    // - Mark visited nodes by changing data
    // - If we see a marked node again → loop exists
    // Time: O(n), Space: O(1)
    // NOTE: This approach is generally avoided because it mutates data.
    public boolean better(Node head) {
        Node temp = head;

        while (temp != null) {
            if (temp.data == Integer.MIN_VALUE) return true; // marked
            temp.data = Integer.MIN_VALUE; // mark visited
            temp = temp.next;
        }

        return false;
    }

    // Optimal (Floyd’s Cycle Detection Algorithm):
    // - Use slow and fast pointers
    // - slow moves 1 step, fast moves 2 steps
    // - If they meet → loop exists
    // Time: O(n), Space: O(1)
    public boolean optimal(Node head) {
        if (head == null || head.next == null) return false;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;          // move 1 step
            fast = fast.next.next;     // move 2 steps

            if (slow == fast) return true; // loop detected
        }

        return false; // no loop
    }
}
