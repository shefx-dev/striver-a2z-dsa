// Problem: Delete Head of Linked List

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
    // - Create a new list by copying all nodes except the head
    // - Time: O(n), Space: O(n)
    public Node brute(Node head) {
        if (head == null) return null;

        Node newHead = null;
        Node newTail = null;
        Node temp = head.next; // skip the head

        while (temp != null) {
            Node newNode = new Node(temp.data);

            if (newHead == null) {
                newHead = newNode;
                newTail = newNode;
            } else {
                newTail.next = newNode;
                newTail = newNode;
            }

            temp = temp.next;
        }

        return newHead;
    }

    // Better:
    // - Just move head to head.next
    // - Time: O(1), Space: O(1)
    public Node better(Node head) {
        if (head == null) return null;
        return head.next;
    }

    // Optimal (same as Better)
    // - Time: O(1), Space: O(1)
    public Node optimal(Node head) {
        if (head == null) return null;
        return head.next;
    }
}
