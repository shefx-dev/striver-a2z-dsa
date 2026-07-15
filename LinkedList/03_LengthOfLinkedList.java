// Problem: Find Length of Linked List

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
    // - Return the size of the array
    // Time: O(n), Space: O(n)
    public int brute(Node head) {
        java.util.ArrayList<Integer> list = new java.util.ArrayList<>();

        Node temp = head;
        while (temp != null) {
            list.add(temp.data);
            temp = temp.next;
        }

        return list.size();
    }

    // Better:
    // - Traverse and count nodes
    // - Time: O(n), Space: O(1)
    public int better(Node head) {
        int count = 0;
        Node temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }

    // Optimal (same as Better)
    // Time: O(n), Space: O(1)
    public int optimal(Node head) {
        int count = 0;
        Node temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }
}
