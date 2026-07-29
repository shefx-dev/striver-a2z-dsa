// Problem: Implement Queue using Arrays

// Brute Force Approach:
// - Use array, pop() shifts all elements left
// - Time Complexity: O(n) for pop
// - Space Complexity: O(n)

// Better Approach:
// - Use front and rear pointers
// - Push at rear, Pop at front
// - Time Complexity: O(1)
// - Space Complexity: O(n)

// Optimal Approach:
// - Use circular array with front/rear modulo capacity
// - Time Complexity: O(1)
// - Space Complexity: O(n)

class QueueArray {
    int[] arr;
    int front, rear, size, capacity;

    public QueueArray(int cap) {
        capacity = cap;
        arr = new int[capacity];
        front = 0; rear = -1; size = 0;
    }

    // Brute: pop with shifting
    public int brutePop() {
        if(size == 0) return -1;
        int val = arr[0];
        for(int i = 1; i < size; i++) arr[i-1] = arr[i];
        size--;
        return val;
    }

    // Better: linear queue
    public void push(int x) {
        if(size == capacity) return;
        arr[++rear] = x;
        size++;
    }

    public int betterPop() {
        if(size == 0) return -1;
        int val = arr[front++];
        size--;
        return val;
    }

    // Optimal: circular queue
    public void optimalPush(int x) {
        if(size == capacity) return;
        rear = (rear+1) % capacity;
        arr[rear] = x;
        size++;
    }

    public int optimalPop() {
        if(size == 0) return -1;
        int val = arr[front];
        front = (front+1) % capacity;
        size--;
        return val;
    }
}
