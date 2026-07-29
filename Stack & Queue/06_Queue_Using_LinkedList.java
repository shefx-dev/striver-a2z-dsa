// Problem: Implement Queue using Linked List

// Brute Force Approach:
// - Use linked list, push at head, pop at tail (O(n))
// - Time Complexity: O(n)
// - Space Complexity: O(n)

// Better Approach:
// - Use linked list with front and rear pointers
// - Push at rear, Pop at front
// - Time Complexity: O(1)
// - Space Complexity: O(n)

// Optimal Approach:
// - Same as Better (front/rear pointers)
// - Time Complexity: O(1)
// - Space Complexity: O(n)

class LinkedListQueue {
    Node front, rear;

    public void push(int x) {
        Node temp = new Node(x);
        if(rear == null) {
            front = rear = temp;
        } else {
            rear.next = temp;
            rear = temp;
        }
    }

    public int pop() {
        if(front == null) return -1;
        int val = front.data;
        front = front.next;
        if(front == null) rear = null;
        return val;
    }

    public int peek() {
        return front == null ? -1 : front.data;
    }
}
