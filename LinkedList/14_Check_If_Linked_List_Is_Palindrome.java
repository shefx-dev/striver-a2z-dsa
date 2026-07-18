// Problem: Check if a Singly Linked List is a Palindrome

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
    // - Traverse linked list and store values in an ArrayList
    // - Compare list with its reverse
    // Time: O(n), Space: O(n)
    public boolean brute(Node head) {
        java.util.ArrayList<Integer> list = new java.util.ArrayList<>();
        Node temp = head;

        while (temp != null) {
            list.add(temp.data);
            temp = temp.next;
        }

        int i = 0, j = list.size() - 1;
        while (i < j) {
            if (!list.get(i).equals(list.get(j))) return false;
            i++;
            j--;
        }

        return true;
    }

    // Better:
    // - Use a stack to store first half of elements
    // - Compare with second half while traversing
    // Time: O(n), Space: O(n)
    public boolean better(Node head) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        Node slow = head;
        Node fast = head;

        // Push first half into stack
        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        // Skip middle element for odd length
        if (fast != null) slow = slow.next;

        // Compare second half with stack
        while (slow != null) {
            if (stack.pop() != slow.data) return false;
            slow = slow.next;
        }

        return true;
    }

    // Optimal:
    // - Find middle using slow & fast pointers
    // - Reverse second half of list
    // - Compare first half and reversed second half
    // - Restore list if needed
    // Time: O(n), Space: O(1)
    public boolean optimal(Node head) {
        if (head == null || head.next == null) return true;

        // Step 1: Find middle
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        Node secondHalf = reverse(slow);

        // Step 3: Compare halves
        Node firstHalf = head;
        Node temp = secondHalf;
        boolean palindrome = true;
        while (temp != null) {
            if (firstHalf.data != temp.data) {
                palindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            temp = temp.next;
        }

        // Step 4: Restore list (optional)
        reverse(secondHalf);

        return palindrome;
    }

    // Helper function to reverse a linked list
    private Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
