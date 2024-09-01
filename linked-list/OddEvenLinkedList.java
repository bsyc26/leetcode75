/** Re-order the linked-list into starting with odd(1st) indices following by even indices, return head
  * T: O(N), S: O(1). */
public class OddEvenLinkedList { // leetcode 328
    // two-pointers:fast-slow
    public ListNode oddEvenList(ListNode head) { // T: O(N), S: O(1).
        // edge case
        if (head == null)
            return null;
        // variables
        ListNode slow = head; // odd-1st
        ListNode fast = head.next; // even-2nd
        ListNode firstEven = fast; // keep 2nd loc to link odd and even
        // two-pointers
        while (fast != null && fast.next != null) { // e.g. 1 -> 2 -> 3 -> 4
            slow.next = fast.next; // 1 -> 3
            slow = slow.next; // slow at 3
            fast.next = slow.next; // 2 -> 4
            fast = fast.next; // fast at 4
        }
        slow.next = firstEven; // 3 -> 2
        // return
        return head;
    }
}
