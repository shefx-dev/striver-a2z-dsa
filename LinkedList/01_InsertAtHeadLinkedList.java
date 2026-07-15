// Problem: Insert at Head of Linked List

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
    // - Create a new list and copy all nodes
    // - Insert new node at the beginning
    // Time: O(n), Space: O(n)
    public Node brute(Node head, int val) {
        Node newHead = new Node(val);

        // Copy old list
        Node temp = head;
        Node copyTail = newHead;

        while (temp != null) {
            Node newNode = new Node(temp.data);
            copyTail.next = newNode;
            copyTail = newNode;
            temp = temp.next;
        }

        return newHead;
    }

    // Better:
    // - Create new node
    // - Point newNode.next to head
    // - Return newNode
    // Time: O(1), Space: O(1)
    public Node better(Node head, int val) {
        Node newHead = new Node(val);
        newHead.next = head;
        return newHead;
    }

    // Optimal (same as Better)
    // Time: O(1), Space: O(1)
    public Node optimal(Node head, int val) {
        Node newHead = new Node(val);
        newHead.next = head;
        return newHead;
    }
}
