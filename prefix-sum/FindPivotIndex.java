/** Return the leftmost pivot index or -1
  * pivot index: sum of left elems equals to sum of right elems for pivot index */
public class FindPivotIndex { // leetcode 724
    // prefix-sum
    public int pivotIndex(int[] nums) { // T: O(N), S: O(N).
        // constants
        int N = nums.length;
        // data structures
        int[] preSum = new int[N+1];
        preSum[0] = 0;
        for (int i = 1; i < N+1; i++)
            preSum[i] = preSum[i-1] + nums[i-1];
        int[] postSum = new int[N+1];
        postSum[N] = 0;
        for (int i = N-2; i >= 0; i--)
            postSum[i] = postSum[i+1] + nums[i+1];
        // one-pointer
        for (int i = 0; i < N; i++) // find leftmost pivot index
            if (preSum[i] == postSum[i])
                return i;
        // return fallback
        return -1;
    }
}
