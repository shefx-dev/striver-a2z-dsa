// Problem: Remove Nth node from the back of the Linked List

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
    // - Find (length - n)th node from the front
    // - Remove it by adjusting links
    // Time: O(n), Space: O(1)
    public Node brute(Node head, int n) {
        if (head == null) return null;

        int length = 0;
        Node temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        if (n == length) {
            return head.next;
        }

        int target = length - n;
        temp = head;
        for (int i = 1; i < target; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;

        return head;
    }

    // Better:
    // - Use dummy node to simplify edge cases
    // - Count length, then move to (length - n)th node
    // - Remove target node
    // Time: O(n), Space: O(1)
    public Node better(Node head, int n) {
        Node dummy = new Node(-1);
        dummy.next = head;

        int length = 0;
        Node temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        int target = length - n;
        temp = dummy;
        for (int i = 0; i < target; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;

        return dummy.next;
    }

    // Optimal:
    // - Use two pointers (fast and slow)
    // - Move fast pointer n+1 steps ahead
    // - Move both until fast reaches end
    // - Slow will be just before the node to remove
    // Time: O(n), Space: O(1)
    public Node optimal(Node head, int n) {
        Node dummy = new Node(-1);
        dummy.next = head;

        Node fast = dummy;
        Node slow = dummy;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}
