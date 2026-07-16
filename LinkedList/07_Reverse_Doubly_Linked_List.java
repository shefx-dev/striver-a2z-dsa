// Problem: Reverse a Doubly Linked List

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
    // - Traverse original list and insert each node at head of new list
    // Time: O(n), Space: O(n)
    public Node brute(Node head) {
        if (head == null) return null;

        Node newHead = null;
        Node temp = head;

        while (temp != null) {
            Node newNode = new Node(temp.data);

            // Insert at head of new list
            if (newHead != null) {
                newNode.next = newHead;
                newHead.prev = newNode;
            }

            newHead = newNode;
            temp = temp.next;
        }

        return newHead;
    }

    // Better:
    // - Swap next and prev pointers for each node
    // - Move forward using old prev pointer (now swapped)
    // - Track last processed node as new head
    // Time: O(n), Space: O(1)
    public Node better(Node head) {
        if (head == null) return null;

        Node curr = head;
        Node newHead = null;

        while (curr != null) {
            // Swap next and prev
            Node temp = curr.next;
            curr.next = curr.prev;
            curr.prev = temp;

            // Move to next node (which is prev after swap)
            newHead = curr;
            curr = curr.prev;
        }

        return newHead;
    }

    // Optimal (same as Better)
    // Time: O(n), Space: O(1)
    public Node optimal(Node head) {
        if (head == null) return null;

        Node curr = head;
        Node newHead = null;

        while (curr != null) {
            Node temp = curr.next;
            curr.next = curr.prev;
            curr.prev = temp;

            newHead = curr;
            curr = curr.prev;
        }

        return newHead;
    }
}
