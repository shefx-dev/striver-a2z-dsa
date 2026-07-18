// Problem: Find the starting point of a loop in a Singly Linked List

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
    // - First node that repeats → starting point of loop
    // Time: O(n), Space: O(n)
    public Node brute(Node head) {
        java.util.HashSet<Node> set = new java.util.HashSet<>();
        Node temp = head;

        while (temp != null) {
            if (set.contains(temp)) return temp; // first repeating node
            set.add(temp);
            temp = temp.next;
        }

        return null; // no loop
    }

    // Better:
    // - Modify node values (NOT recommended in interviews)
    // - Mark visited nodes by changing data
    // - First marked node encountered again → starting point
    // Time: O(n), Space: O(1)
    // NOTE: Avoided in practice because it mutates data.
    public Node better(Node head) {
        Node temp = head;

        while (temp != null) {
            if (temp.data == Integer.MIN_VALUE) return temp; // starting point
            temp.data = Integer.MIN_VALUE; // mark visited
            temp = temp.next;
        }

        return null;
    }

    // Optimal (Floyd’s Cycle Detection Algorithm):
    // Step 1: Detect loop using slow & fast pointers
    // Step 2: When they meet, reset one pointer to head
    // Step 3: Move both one step at a time → meeting point = start of loop
    // Time: O(n), Space: O(1)
    public Node optimal(Node head) {
        if (head == null || head.next == null) return null;

        Node slow = head;
        Node fast = head;

        // Step 1: Detect loop
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Step 2: Reset one pointer to head
                slow = head;

                // Step 3: Move both one step at a time
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow; // starting point of loop
            }
        }

        return null; // no loop
    }
}
