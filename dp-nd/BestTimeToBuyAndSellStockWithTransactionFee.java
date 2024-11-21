// leetcode 714
// dp-nd:table
// T: O(N)
// S: O(N)

class Solution {

    /** Return the max profit to achieve from prices[] with transaction fee
      * transaction fee only charge once for buy or sell */
    public int maxProfit(int[] prices, int fee) {
        // const
        int N = prices.length;
        // DS:dp-table
        int[][] dp = new int[N][2]; // dp[i][0] is sell at i-th, dp[i][1] is buy at i-th
        for (int i = 0; i < N; i++) {
            // base case
            if (i - 1 == -1) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i] - fee; // buy prices[i]
                continue;
            }
            // state transfer
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]-fee);
        }
        // return res
        return dp[N-1][0];
    }

}
