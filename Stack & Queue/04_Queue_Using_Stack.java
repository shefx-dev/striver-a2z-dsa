// Problem: Implement Queue using Stack

// Brute Force Approach:
// - Use two stacks, push in one, transfer all to other for pop
// - Time Complexity: O(n) for pop
// - Space Complexity: O(n)

// Better Approach:
// - Use two stacks: inStack and outStack
// - Push in inStack, Pop from outStack (transfer only when needed)
// - Time Complexity: Amortized O(1)
// - Space Complexity: O(n)

// Optimal Approach:
// - Same as Better (two stacks with lazy transfer)
// - Time Complexity: Amortized O(1)
// - Space Complexity: O(n)

import java.util.Stack;

class QueueStack {
    Stack<Integer> inStack = new Stack<>();
    Stack<Integer> outStack = new Stack<>();

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if(outStack.isEmpty()) {
            while(!inStack.isEmpty()) outStack.push(inStack.pop());
        }
        return outStack.isEmpty() ? -1 : outStack.pop();
    }

    public int peek() {
        if(outStack.isEmpty()) {
            while(!inStack.isEmpty()) outStack.push(inStack.pop());
        }
        return outStack.isEmpty() ? -1 : outStack.peek();
    }
}
