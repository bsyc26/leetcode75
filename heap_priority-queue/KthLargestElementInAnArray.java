import java.util.PriorityQueue;

/** Return the k-th largest element in nums[] + without sorting (follow up)*/
public class Solution { // leetcode 215
    // pq
    public int findKthLargest(int[] nums, int k) { // T: O(N), S: O(K).
        // constants
        int K = k; // the k-th max elem
        // data structures
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // ascending order
        // scan update
        for (int num : nums) {
            // offer
            pq.offer(num);
            // poll
            if (pq.size() > K)
                pq.poll();
        }
        // return
        return pq.peek(); // top is smallest of the left k nums
    }
}
