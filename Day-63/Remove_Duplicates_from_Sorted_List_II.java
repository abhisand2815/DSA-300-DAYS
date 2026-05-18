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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {

            // detect duplicates
            if (curr.next != null && curr.val == curr.next.val) {
                
                // skip all duplicates
                while (curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }

                // remove all duplicates
                prev.next = curr.next;
            } 
            else {
                // move prev only if no duplicate
                prev = prev.next;
            }

            curr = curr.next;
        }

        return dummy.next;
    }
}
