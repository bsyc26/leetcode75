/** Return the max altitude 
  * gain[i] is the delta between i and i+1, init with altitude 0 */
public class FindTheHighestAltitude { // leetcode 1732
    // prefix-sum
    public int largestAltitude(int[] gain) { // T: O(N), S: O(N).
        // constants
        int N = gain.length;
        // variables
        int maxH = 0; // init with altitude 0
        // data structures
        int[] preSum = new int[N+1]; // preSum[i] is the sum of gain[0..i-1]
        preSum[0] = 0;
        for (int i = 1; i < N+1; i++) {
            preSum[i] = preSum[i-1] + gain[i-1];
            maxH = Math.max(maxH, preSum[i]);
        }
        // return
        return maxH;
    }
}
