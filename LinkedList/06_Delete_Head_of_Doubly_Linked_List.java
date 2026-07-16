// Problem: Delete Head of Doubly Linked List

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class Solution {

    // Brute Force:
    // - Create a new list
    // - Copy all nodes except the head
    // Time: O(n), Space: O(n)
    public Node brute(Node head) {
        if (head == null) return null;

        Node temp = head.next; // start copying from second node
        Node dummy = new Node(-1);
        Node tail = dummy;

        while (temp != null) {
            Node newNode = new Node(temp.data);
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            temp = temp.next;
        }

        return dummy.next;
    }

    // Better:
    // - Move head to head.next
    // - Set new head.prev = null
    // Time: O(1), Space: O(1)
    public Node better(Node head) {
        if (head == null) return null;

        Node newHead = head.next;

        if (newHead != null) {
            newHead.prev = null;
        }

        return newHead;
    }

    // Optimal (same as Better)
    // Time: O(1), Space: O(1)
    public Node optimal(Node head) {
        if (head == null) return null;

        Node newHead = head.next;

        if (newHead != null) {
            newHead.prev = null;
        }

        return newHead;
    }
}
