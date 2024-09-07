/** Reverse and return the reversed list */
public class Solution { // leetcode 206
    // iteration
    public ListNode reverseList(ListNode head) { // T: O(N), S: O(1).
        // variables
        ListNode pred = null; // ! ensure no circle
        ListNode cur = head;
        // two pointers
        while (cur != null) { // null -> 1 -> 2 -> ..
            ListNode suc = cur.next; // suc at 2
            cur.next = pred; // null <- 1
            pred = cur; // pred at null
            cur = suc; // cur at 2
        } // 1 -> null () 2 -> ..
        // return
        return pred;
    }

    // recursion
    public ListNode reverseList(ListNode head) { // T: O(N), S: O(1).
        // base case
        if (head == null || head.next == null)
            return head;
        // recur case
        ListNode rev = reverseList(head.next); // head -> rev
        head.next.next = head; // head -> <- rev
        head.next = null; // null <- head <- rev
        // return
        return rev;
    }
}
