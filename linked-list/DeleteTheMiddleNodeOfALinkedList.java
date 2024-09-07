/** Delete the middle (right if tot even) node and return the head of modified linked list */
public class Solution { // leetcode 2095
    // two-pointers:fast-slow
    public ListNode deleteMiddle(ListNode head) { // T: O(N), S: O(1).
        // edge case
        if (head == null || head.next == null)
            return null;
        // variables
        ListNode slow = head;
        ListNode fast = head.next.next;
        // two pointers
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // remove the middle node (slow.next)
        slow.next = slow.next.next; 
        // return
        return head;
    }
}
