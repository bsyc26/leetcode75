import java.util.PriorityQueue;

/** Return the total cost to hire just k workers
  * total k sessions and hire one worker in each session (front / last in turns)
  * each session choose the worker with lowest cost, if tie then min index */
public class TotalCostToHireWorkers { // leetcode 2462
    // pq:two-heap
    public long totalCost(int[] costs, int k, int candiates) { // T: O(MLogN), S: O(N).
        // constants
        int N = costs.length;
        // variables
        long totCost = 0;
        int left = 0;
        int right = N-1;
        // data structures
        PriorityQueue<Integer> minHeapL = new PriorityQueue<>();
        PriorityQueue<Integer> minHeapR = new PriorityQueue<>();
        // loop k sessions
        for (int i = 0; i < k; i++) {
            // offer
            while (minHeapL.size() < candidates && left <= right) {
                minHeapL.offer(costs[left]);
                ++left;
            }
            while (minHeapR.size() < candidates && left <= right) {
                minHeapR.offer(costs[right]);
                --right;
            }
            // poll
            if (minHeapL.isEmpty())
                totCost += minHeapR.poll();
            else if (minHeapR.isEmpty())
                totCost += minHeapL.poll();
            else if (minHeapL.peek() <= minHeapR.peek())
                totCost += minHeapL.poll();
            else
                totCost += minHeapR.poll();
        }
        // return
        return totCost;
    }
}
