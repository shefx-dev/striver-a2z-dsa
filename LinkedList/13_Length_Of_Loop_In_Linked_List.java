// Problem: Find the length of the loop in a Singly Linked List

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
    // - Use a HashSet to store visited nodes
    // - If a node repeats, traverse the loop until we reach it again
    // - Count the number of nodes in this cycle
    // Time: O(n), Space: O(n)
    public int brute(Node head) {
        java.util.HashSet<Node> set = new java.util.HashSet<>();
        Node temp = head;

        while (temp != null) {
            if (set.contains(temp)) {
                // Found loop start → count length
                Node start = temp;
                int count = 1;
                temp = temp.next;
                while (temp != start) {
                    count++;
                    temp = temp.next;
                }
                return count;
            }
            set.add(temp);
            temp = temp.next;
        }

        return 0; // no loop
    }

    // Better:
    // - Mutate node values (NOT recommended in interviews)
    // - Mark visited nodes by changing data
    // - When we encounter a marked node, traverse the loop to count length
    // Time: O(n), Space: O(1)
    // NOTE: Avoided in practice because it mutates data.
    public int better(Node head) {
        Node temp = head;

        while (temp != null) {
            if (temp.data == Integer.MIN_VALUE) {
                // Found loop start → count length
                Node start = temp;
                int count = 1;
                temp = temp.next;
                while (temp != start) {
                    count++;
                    temp = temp.next;
                }
                return count;
            }
            temp.data = Integer.MIN_VALUE; // mark visited
            temp = temp.next;
        }

        return 0;
    }

    // Optimal (Floyd’s Cycle Detection Algorithm):
    // Step 1: Detect loop using slow & fast pointers
    // Step 2: When they meet, keep one pointer fixed
    // Step 3: Move the other pointer until it meets again, counting steps
    // Time: O(n), Space: O(1)
    public int optimal(Node head) {
        if (head == null || head.next == null) return 0;

        Node slow = head;
        Node fast = head;

        // Step 1: Detect loop
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Step 2 & 3: Count loop length
                int count = 1;
                fast = fast.next;
                while (slow != fast) {
                    count++;
                    fast = fast.next;
                }
                return count;
            }
        }

        return 0; // no loop
    }
}
