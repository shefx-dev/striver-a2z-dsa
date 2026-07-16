// Problem: Insert Node Before Head in Doubly Linked List

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
    // - Copy all nodes and insert new node at beginning
    // Time: O(n), Space: O(n)
    public Node brute(Node head, int val) {
        Node newHead = new Node(val);

        // Copy old list
        Node temp = head;
        Node copyTail = newHead;

        while (temp != null) {
            Node newNode = new Node(temp.data);
            copyTail.next = newNode;
            newNode.prev = copyTail;
            copyTail = newNode;
            temp = temp.next;
        }

        return newHead;
    }

    // Better:
    // - Create new node
    // - Point newNode.next to head
    // - Update head.prev to newNode
    // - Return newNode
    // Time: O(1), Space: O(1)
    public Node better(Node head, int val) {
        Node newHead = new Node(val);

        if (head != null) {
            newHead.next = head;
            head.prev = newHead;
        }

        return newHead;
    }

    // Optimal (same as Better)
    // Time: O(1), Space: O(1)
    public Node optimal(Node head, int val) {
        Node newHead = new Node(val);

        if (head != null) {
            newHead.next = head;
            head.prev = newHead;
        }

        return newHead;
    }
}
