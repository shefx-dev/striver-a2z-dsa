// Problem: Delete the middle node in a Linked List

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
    // - Traverse the list to count total nodes
    // - Find middle index = (length / 2) + 1 (1-based)
    // - Traverse again to that node and delete it
    // Time: O(2n) ~ O(n), Space: O(1)
    public Node brute(Node head) {
        if (head == null || head.next == null) return null;

        int length = 0;
        Node temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        int middle = (length / 2) + 1;

        // If middle is the first node
        if (middle == 1) return head.next;

        temp = head;
        for (int i = 1; i < middle - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;

        return head;
    }

    // Better:
    // - Use dummy node to simplify edge cases
    // - Count length, then move to (middle - 1)th node
    // - Delete middle node
    // Time: O(n), Space: O(1)
    public Node better(Node head) {
        if (head == null || head.next == null) return null;

        Node dummy = new Node(-1);
        dummy.next = head;

        int length = 0;
        Node temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        int middle = (length / 2) + 1;

        temp = dummy;
        for (int i = 0; i < middle - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;

        return dummy.next;
    }

    // Optimal:
    // - Use slow and fast pointers
    // - Move fast by 2 steps, slow by 1 step
    // - When fast reaches end, slow is at middle
    // - Keep track of prev to delete slow
    // Time: O(n), Space: O(1)
    public Node optimal(Node head) {
        if (head == null || head.next == null) return null;

        Node slow = head;
        Node fast = head;
        Node prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow is middle node, delete it
        prev.next = slow.next;

        return head;
    }
}
