// Problem: Implement Stack using Linked List

// Brute Force Approach:
// - Use linked list, push at rear, pop from rear (O(n))
// - Time Complexity: O(n) for pop
// - Space Complexity: O(n)

// Better Approach:
// - Use linked list, push/pop at head
// - Time Complexity: O(1)
// - Space Complexity: O(n)

// Optimal Approach:
// - Same as Better (head operations)
// - Time Complexity: O(1)
// - Space Complexity: O(n)

class Node {
    int data;
    Node next;
    Node(int val) { data = val; next = null; }
}

class StackLinkedList {
    Node head;

    public void push(int x) {
        Node temp = new Node(x);
        temp.next = head;
        head = temp;
    }

    public int pop() {
        if(head == null) return -1;
        int val = head.data;
        head = head.next;
        return val;
    }

    public int top() {
        return head == null ? -1 : head.data;
    }
}
