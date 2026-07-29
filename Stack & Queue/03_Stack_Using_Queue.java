// Problem: Implement Stack using Queue

// Brute Force Approach:
// - Use two queues, push in one, transfer elements
// - Time Complexity: O(n) for push
// - Space Complexity: O(n)

// Better Approach:
// - Use single queue, rotate elements after push
// - Time Complexity: O(n) for push, O(1) for pop/top
// - Space Complexity: O(n)

// Optimal Approach:
// - Same as Better (single queue rotation)
// - Time Complexity: O(n) push, O(1) pop/top
// - Space Complexity: O(n)

import java.util.LinkedList;
import java.util.Queue;

class StackQueue {
    Queue<Integer> q = new LinkedList<>();

    // Better/Optimal
    public void push(int x) {
        q.add(x);
        int sz = q.size();
        for(int i=0; i<sz-1; i++) {
            q.add(q.poll());
        }
    }

    public int pop() {
        return q.isEmpty() ? -1 : q.poll();
    }

    public int top() {
        return q.isEmpty() ? -1 : q.peek();
    }
}
