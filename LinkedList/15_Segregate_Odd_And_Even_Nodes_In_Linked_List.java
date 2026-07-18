// Problem: Segregate odd and even indexed nodes in a Singly Linked List

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
    // - Traverse the list, store odd-indexed nodes in one list and even-indexed nodes in another
    // - Concatenate odd list followed by even list
    // Time: O(n), Space: O(n)
    public Node brute(Node head) {
        if (head == null) return null;

        java.util.ArrayList<Integer> odd = new java.util.ArrayList<>();
        java.util.ArrayList<Integer> even = new java.util.ArrayList<>();

        Node temp = head;
        int index = 1;

        while (temp != null) {
            if (index % 2 == 1) odd.add(temp.data);
            else even.add(temp.data);
            temp = temp.next;
            index++;
        }

        // Build new list
        Node dummy = new Node(-1);
        Node curr = dummy;
        for (int val : odd) {
            curr.next = new Node(val);
            curr = curr.next;
        }
        for (int val : even) {
            curr.next = new Node(val);
            curr = curr.next;
        }

        return dummy.next;
    }

    // Better:
    // - Use two dummy lists: one for odd nodes, one for even nodes
    // - Traverse once, attach nodes accordingly
    // - Concatenate odd list with even list
    // Time: O(n), Space: O(1) (relinking existing nodes)
    public Node better(Node head) {
        if (head == null) return null;

        Node oddDummy = new Node(-1);
        Node evenDummy = new Node(-1);
        Node oddTail = oddDummy;
        Node evenTail = evenDummy;

        Node temp = head;
        int index = 1;

        while (temp != null) {
            if (index % 2 == 1) {
                oddTail.next = temp;
                oddTail = oddTail.next;
            } else {
                evenTail.next = temp;
                evenTail = evenTail.next;
            }
            temp = temp.next;
            index++;
        }

        // Connect odd list to even list
        oddTail.next = evenDummy.next;
        evenTail.next = null;

        return oddDummy.next;
    }

    // Optimal:
    // - Maintain two pointers: odd and even
    // - odd points to first node, even points to second node
    // - Rearrange links in one pass
    // - Finally connect odd list to even list
    // Time: O(n), Space: O(1)
    public Node optimal(Node head) {
        if (head == null || head.next == null) return head;

        Node odd = head;
        Node even = head.next;
        Node evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead; // connect odd list to even list
        return head;
    }
}
