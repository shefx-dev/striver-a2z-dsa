// Problem: Implement Stack using Arrays

// Brute Force Approach:
// - Use an array, and for pop() shift all elements left
// - Time Complexity: O(n) for pop
// - Space Complexity: O(n)

// Better Approach:
// - Use an array with a "top" pointer
// - Push increments top, Pop decrements top
// - Time Complexity: O(1) for push/pop
// - Space Complexity: O(n)

// Optimal Approach:
// - Same as Better (array + top pointer)
// - Time Complexity: O(1)
// - Space Complexity: O(n)

class StackArray {
    int[] arr;
    int top;
    int capacity;

    public StackArray(int cap) {
        capacity = cap;
        arr = new int[capacity];
        top = -1;
    }

    // Brute: pop with shifting
    public int brutePop() {
        if(top == -1) return -1;
        int val = arr[top];
        for(int i = top; i > 0; i--) {
            arr[i] = arr[i-1];
        }
        top--;
        return val;
    }

    // Better: push/pop with top pointer
    public void push(int x) {
        if(top == capacity-1) return;
        arr[++top] = x;
    }

    public int betterPop() {
        if(top == -1) return -1;
        return arr[top--];
    }

    public int optimalPop() {
        return betterPop();
    }
}
