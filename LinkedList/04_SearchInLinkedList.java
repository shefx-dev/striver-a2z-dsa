// Problem: Search in Linked List

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
    // - Copy all nodes into an array/list
    // - Search the array for the key
    // - Time: O(n), Space: O(n)
    public boolean brute(Node head, int key) {
        java.util.ArrayList<Integer> list = new java.util.ArrayList<>();

        Node temp = head;
        while (temp != null) {
            list.add(temp.data);
            temp = temp.next;
        }

        for (int val : list) {
            if (val == key) return true;
        }

        return false;
    }

    // Better:
    // - Traverse the linked list and compare each node
    // - Time: O(n), Space: O(1)
    public boolean better(Node head, int key) {
        Node temp = head;

        while (temp != null) {
            if (temp.data == key) return true;
            temp = temp.next;
        }

        return false;
    }

    // Optimal (same as Better)
    // - Time: O(n), Space: O(1)
    public boolean optimal(Node head, int key) {
        Node temp = head;

        while (temp != null) {
            if (temp.data == key) return true;
            temp = temp.next;
        }

        return false;
    }
}
