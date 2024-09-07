import java.util.PriorityQueue;

/** Return the max possible score
  * choose a sub seq of k size from nums1 (nums1 has the same len with nums2)
  * score: sum of sub seq mutiplies the min of same indices sub seq of nums2 */
public class MaximumSubsequenceScore { // leetcode 2542
    // pq
    public long maxScore(int[] nums1, int[] nums2, int k) { // T: O(NlogN), S: O(N2)
        // constants
        int N = nums1.length;
        // variables
        long score;
        long kSum = 0; // 
        int[][] idxPairs = new int[N][2]; // int[0..N-1] = [nums1[i], nums2[i]]
        for (int i = 0; i < N; i++)
            idxPairs[i] = new int[]{nums1[i], nums2[i]};
        Arrays.sort(idxPairs, (a, b) -> b[1] - a[1]);
        // data structures
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> a - b); // len k, ascending order
        for (int i = 0; i < k; i++) { // init with first k elems of nums1
            kSum += idxPairs[i][0];
            pq.add(idxPairs[i][0]);
        }
        // init
        score = kSum * idxPairs[k-1][1];
        // loop nums2[]
        for (int i = k; i < N; i++) {
            kSum += idxPairs[i][0] - pq.poll();
            pq.add(idxPairs[i][0]);
            score = Math.max(score, kSum*idxPairs[i][1]);
        }
        // return
        return score;
    }
}

