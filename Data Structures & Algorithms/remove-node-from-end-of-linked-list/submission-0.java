/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int size = 0;
        ListNode current = head;

        // Step 1: Calculate size
        while (current != null) {
            size++;
            current = current.next;
        }

        // Step 2: If removing head
        if (size == n) {
            return head.next;
        }

        // Step 3: Go to (size - n - 1) node
        current = head;
        for (int i = 0; i < size - n - 1; i++) {
            current = current.next;
        }

        // Step 4: Remove node
        current.next = current.next.next;

        return head;

    }
}
