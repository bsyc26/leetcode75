import java.util.HashMap;

/** Return the min cost to reach the top of floor
  * cost[i] is the cost of i-th step, can the cost can step either one or two steps
  * init at idx 0 or idx 1 */
public class Solution { // leetcode 746
    // fields
    // data structures
    private HashMap<Integer, Integer> memo = new HashMap<>();
    // dp-memo
    public int minCostClimbingStairs(int[] cost) { // T: O(N), S: O(N).
        return dp(cost.length, cost);
    }
    private int dp(int idx, int[] arr) {
        // base case
        if (idx <= 1)
            return 0;
        // jump case
        if (memo.containsKey(idx))
            return memo.get(idx);
        // state transfer
        int dp1 = arr[idx-1] + dp(idx-1, arr); // dp[i-1]
        int dp2 = arr[idx-2] + dp(idx-2, arr); // dp[i-2]
        // update memo
        memo.put(idx, Math.min(dp1, dp2));
        // return
        return memo.get(idx);
    }
}
