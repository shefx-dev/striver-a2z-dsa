// Problem: Merge two sorted linked lists into one sorted list
// Difficulty: Easy

// Hints:
// - Use recursion
// - Compare heads of both lists
// - Attach the smaller node to the result and recurse

// Approach:
// - If one list is null, return the other
// - Compare l1.val and l2.val
// - Recursively merge the rest

// Time Complexity: O(m+n)
// Space Complexity: O(m+n) due to recursion stack

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode a = new ListNode(1);
        a.next = new ListNode(3);
        ListNode b = new ListNode(2);
        b.next = new ListNode(4);

        ListNode merged = sol.mergeTwoLists(a, b);
        while (merged != null) {
            System.out.print(merged.val + " "); // Output: 1 2 3 4
            merged = merged.next;
        }
    }
}
