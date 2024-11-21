// leetcode 62
// dp-nd:table
// T: O(MN) // M x N is matrix size
// S: O(MN) // M x N is matrix size

import java.util.Arrays;

class Solution {

    /** Return the num of possible uniq path from (0, 0) to (m-1, n-1) 
      * move choice: move down or move right */
    public int uniquePaths(int m, int n) {
        // const
        int M = m; // num of rows
        int N = n; // num of cols
        // DS:dp-table
        int[][] dp = new int[M][N];
        for (int[] row : dp)
            Arrays.fill(row, 1);
        // state transfer
        for (int row = 1; row < M; row++) {
            for (int col = 1; col < N; col++) {
                dp[row][col] = dp[row-1][col] + dp[row][col-1];
            }
        }
        // return res
        return dp[M-1][N-1];
    }

}
