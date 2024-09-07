import java.util.ArrayList;

/** Return the max twin sum of linked-list (size N is even)
  * twin nodes: (0-indexed) i-th is the twin of (N-1-i)-th */
public class Solution { // leetcode 2130
    // linked-list2array
    public int pairSum(ListNode head) { // T: O(N), S: O(N).
        // variables
        ListNode cur = head;
        int left = 0;
        int right;
        int maxSum = Integer.MIN_VALUE;
        // data structures
        ArrayList<Integer> arrList = new ArrayList<>();
        // scan update
        while (cur != null) {
            arrList.add(cur.val);
            cur = cur.next;
        }
        // two pointers on ArrayList
        right = arrList.size()-1;
        while (left < right) {
            int curSum = arrList.get(left) + arrList.get(right);
            maxSum = Math.max(maxSum, curSum);
            ++left;
            --right;
        }
        // return
        return maxSum;
    }
}
