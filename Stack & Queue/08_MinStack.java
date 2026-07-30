// Problem: Implement Min Stack

// Brute Force Approach:
// - Use a normal stack to store elements
// - On getMin(), traverse the entire stack to find minimum
// - Time Complexity: O(n) for getMin()
// - Space Complexity: O(n)

// Better Approach:
// - Use two stacks: one for all elements, one for current minimums
// - On push: push element to main stack, and push min(currentMin, element) to min stack
// - On pop: pop from both stacks
// - On getMin(): return top of min stack
// - Time Complexity: O(1) for all operations
// - Space Complexity: O(n)

// Optimal Approach:
// - Use one stack with encoding trick
// - Maintain a variable minValue
// - On push: if new value < minValue, push encoded value (2*value - minValue) and update minValue
// - On pop: if popped value < minValue, decode previous min
// - On top: if top < minValue, return minValue; else return top
// - On getMin: return minValue
// - Time Complexity: O(1) for all operations
// - Space Complexity: O(1) extra (beyond stack)

import java.util.Stack;

class MinStack {

    // Brute Force
    Stack<Integer> bruteStack = new Stack<>();
    public void brutePush(int x) { bruteStack.push(x); }
    public void brutePop() { if(!bruteStack.isEmpty()) bruteStack.pop(); }
    public int bruteTop() { return bruteStack.isEmpty() ? -1 : bruteStack.peek(); }
    public int bruteGetMin() {
        if(bruteStack.isEmpty()) return -1;
        int min = Integer.MAX_VALUE;
        for(int val : bruteStack) {
            min = Math.min(min, val);
        }
        return min;
    }

    // Better (two stacks)
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    public void betterPush(int x) {
        stack.push(x);
        if(minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        } else {
            minStack.push(minStack.peek());
        }
    }
    public void betterPop() {
        if(!stack.isEmpty()) {
            stack.pop();
            minStack.pop();
        }
    }
    public int betterTop() { return stack.isEmpty() ? -1 : stack.peek(); }
    public int betterGetMin() { return minStack.isEmpty() ? -1 : minStack.peek(); }

    // Optimal (encoding trick)
    Stack<Long> optStack = new Stack<>();
    long minValue;
    public void optimalPush(int x) {
        long val = x;
        if(optStack.isEmpty()) {
            optStack.push(val);
            minValue = val;
        } else if(val < minValue) {
            optStack.push(2L * val - minValue);
            minValue = val;
        } else {
            optStack.push(val);
        }
    }
    public void optimalPop() {
        if(optStack.isEmpty()) return;
        long top = optStack.pop();
        if(top < minValue) {
            minValue = 2L * minValue - top;
        }
    }
    public int optimalTop() {
        if(optStack.isEmpty()) return -1;
        long top = optStack.peek();
        return (top < minValue) ? (int)minValue : (int)top;
    }
    public int optimalGetMin() {
        if(optStack.isEmpty()) return -1;
        return (int)minValue;
    }
}
