/** Return the value of Tn given n
  * tribonacci Tn: T0=0, T1=1, T2=1, Tn+3=Tn+Tn+1+Tn+2 */
public class Solution { // leetcode 1137
    // dp-table
    public int tribonacci(int n) { // T: O(N), S: O(N).
        // base case
        if (n < 3)
            return n > 0 ? 1 : 0;
        // data structures
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        // state transfer
        for (int i = 3; i <= n; i++)
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        // return
        return dp[n];
    }
}
