import java.util.PriorityQueue;

/** Return the k-th largest element in nums[] + without sorting (follow up)*/
public class KthLargestElementInAnArray { // leetcode 215
    // priority-queue
    public int findKthLargest(int[] nums, int k) { // T: O(N), S: O(K).
        // data structures
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // ascending order
        // one-pointer
        for (int num : nums) {
            // offer
            pq.offer(num);
            // poll
            if (pq.size() > k)
                pq.poll();
        }
        // return
        return pq.peek(); // top is smallest of the left k nums
    }
}
