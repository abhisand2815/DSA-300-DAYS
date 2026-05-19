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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Step 1: find length
        ListNode curr = head;
        int length = 1;

        while (curr.next != null) {
            curr = curr.next;
            length++;
        }

        // Step 2: make it circular
        curr.next = head;

        // Step 3: find new head position
        k = k % length;
        int stepsToNewHead = length - k;

        ListNode newTail = curr;

        for (int i = 0; i < stepsToNewHead; i++) {
            newTail = newTail.next;
        }

        // Step 4: break the circle
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
