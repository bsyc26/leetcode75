import java.util.Arrays;

/** Return thee max money to rob without alerting the police
  * nums[i] is the money of i-th house, police will be alerting if two adj houses were robbed */
public class Solution { // leetcode 198
    // fields
    private int[] memo;
    // dp-memo
    public int rob(int[] nums) { // T: O(N), S: O(N).
        // constants
        int N = nums.length;
        // data structures
        memo = new int[N];
        Arrays.fill(memo, -1);
        // return
        return dp(nums, 0);
    }
    private int dp(int[] nums, int start) { // return the max rob money of dp[start..N-1]
        // constants
        int N = nums.length;
        // base case
        if (start >= N)
            return 0;
        // jump case
        if (memo[start] != -1)
            return memo[start];
        // state transfer
        int maxMoney = Math.max(
                dp(nums, start+1), // no adj house
                nums[start] + dp(nums, start+2)
        );
        // update memo
        memo[start] = maxMoney;
        // return
        return maxMoney;
    }

    // dp-table
    public int rob(int[] nums) { // T: O(N), S: O(N).
        // constants
        int N = nums.length;
        // data structures
        int[] dp = new int[N+2];
        // state transfer
        for (int i = N-1; i >= 0; i--)
            dp[i] = Math.max(dp[i+1], nums[i]+dp[i+2]);
        // return
        return dp[0];
    }

    // dp-state
    public int rob(int[] nums) { // T: O(N), S: O(1).
        // constants
        int N = nums.length;
        // data structures
        int dp0 = 0; // dp[i]
        int dp1 = 0; // dp[i+1]
        int dp2 = 0; // dp[i+2]
        // state transfer
        for (int i = N-1; i >= 0; i--) {
            dp0 = Math.max(dp1, nums[i]+dp2);
            dp2 = dp1;
            dp1 = dp0;
        }
        // return
        return dp0;
    }
}
