// Problem: Find Middle of Linked List
// If even number of nodes → return the second middle node

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
    // - Traverse list and count nodes
    // - Middle index = count/2 (this automatically gives second middle for even length)
    // - Traverse again to reach middle index
    // Time: O(n), Space: O(1)
    public Node brute(Node head) {
        if (head == null) return null;

        int count = 0;
        Node temp = head;

        // Count nodes
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        int midIndex = count / 2; // gives second middle for even length

        temp = head;
        while (midIndex-- > 0) {
            temp = temp.next;
        }

        return temp;
    }

    // Better:
    // - Store nodes in an array/list
    // - Return element at index size/2
    // Time: O(n), Space: O(n)
    public Node better(Node head) {
        if (head == null) return null;

        java.util.ArrayList<Node> list = new java.util.ArrayList<>();
        Node temp = head;

        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }

        return list.get(list.size() / 2);
    }

    // Optimal:
    // - Use slow and fast pointer
    // - slow moves 1 step, fast moves 2 steps
    // - When fast reaches end, slow is at middle
    // - For even length, slow naturally lands on second middle
    // Time: O(n), Space: O(1)
    public Node optimal(Node head) {
        if (head == null) return null;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;       // move 1 step
            fast = fast.next.next;  // move 2 steps
        }

        return slow;
    }
}
