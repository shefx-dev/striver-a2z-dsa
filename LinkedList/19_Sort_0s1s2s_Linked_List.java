// Problem: Sort a Linked List of 0's, 1's and 2's in non-decreasing order

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
    // - Traverse the list and count number of 0s, 1s, and 2s
    // - Overwrite values back into the original nodes
    // Time: O(n), Space: O(1)
    public Node better(Node head) {
        if (head == null || head.next == null) return head;

        int count0 = 0, count1 = 0, count2 = 0;
        Node temp = head;
        while (temp != null) {
            if (temp.data == 0) count0++;
            else if (temp.data == 1) count1++;
            else count2++;
            temp = temp.next;
        }

        temp = head;
        while (count0-- > 0) {
            temp.data = 0;
            temp = temp.next;
        }
        while (count1-- > 0) {
            temp.data = 1;
            temp = temp.next;
        }
        while (count2-- > 0) {
            temp.data = 2;
            temp = temp.next;
        }

        return head;
    }

    // Optimal:
    // - Use three dummy lists: one for 0s, one for 1s, one for 2s
    // - Traverse the original list and link nodes into respective lists
    // - Merge the three lists together
    // - No new nodes created, only relinking
    // Time: O(n), Space: O(1)
    public Node optimal(Node head) {
        if (head == null || head.next == null) return head;

        Node zeroDummy = new Node(-1), oneDummy = new Node(-1), twoDummy = new Node(-1);
        Node zero = zeroDummy, one = oneDummy, two = twoDummy;

        Node temp = head;
        while (temp != null) {
            if (temp.data == 0) {
                zero.next = temp;
                zero = zero.next;
            } else if (temp.data == 1) {
                one.next = temp;
                one = one.next;
            } else {
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }

        // Connect the three lists
        zero.next = (oneDummy.next != null) ? oneDummy.next : twoDummy.next;
        one.next = twoDummy.next;
        two.next = null;

        return zeroDummy.next;
    }
}
