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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupPrev = dummy;

        while (true) {
            // Step 1: find kth node
            ListNode kth = getKth(groupPrev, k);
            if (kth == null) break;

            ListNode groupNext = kth.next;

            // Step 2: reverse group
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;

            while (curr != groupNext) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            // Step 3: reconnect
            ListNode temp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = temp;
        }

        return dummy.next;
    }

    // helper function to get kth node
    private ListNode getKth(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
}
