// Problem: Sort the values of a Linked List in non-decreasing order

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
    // - Traverse the list and store values in an array
    // - Sort the array
    // - Rebuild the linked list with sorted values
    // Time: O(n log n), Space: O(n)
    public Node brute(Node head) {
        if (head == null || head.next == null) return head;

        java.util.ArrayList<Integer> arr = new java.util.ArrayList<>();
        Node temp = head;
        while (temp != null) {
            arr.add(temp.data);
            temp = temp.next;
        }

        java.util.Collections.sort(arr);

        Node dummy = new Node(-1);
        Node curr = dummy;
        for (int val : arr) {
            curr.next = new Node(val);
            curr = curr.next;
        }

        return dummy.next;
    }

    // Better:
    // - Traverse the list, store values in an array
    // - Sort the array
    // - Instead of rebuilding, overwrite values back into the original nodes
    // Time: O(n log n), Space: O(n)
    public Node better(Node head) {
        if (head == null || head.next == null) return head;

        java.util.ArrayList<Integer> arr = new java.util.ArrayList<>();
        Node temp = head;
        while (temp != null) {
            arr.add(temp.data);
            temp = temp.next;
        }

        java.util.Collections.sort(arr);

        temp = head;
        int i = 0;
        while (temp != null) {
            temp.data = arr.get(i++);
            temp = temp.next;
        }

        return head;
    }

    // Optimal:
    // - Use Merge Sort directly on the linked list
    // - Find middle using slow/fast pointers
    // - Recursively sort left and right halves
    // - Merge two sorted halves
    // Time: O(n log n), Space: O(log n) recursion stack
    public Node optimal(Node head) {
        if (head == null || head.next == null) return head;

        Node mid = getMid(head);
        Node left = optimal(head);
        Node right = optimal(mid);

        return merge(left, right);
    }

    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node mid = slow.next;
        slow.next = null;
        return mid;
    }

    private Node merge(Node left, Node right) {
        Node dummy = new Node(-1);
        Node tail = dummy;

        while (left != null && right != null) {
            if (left.data <= right.data) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }

        if (left != null) tail.next = left;
        else tail.next = right;

        return dummy.next;
    }
}
