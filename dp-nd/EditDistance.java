// leetcode 72
// dp-nd:table
// T: O(MN) // M is word1.length(), N is word2.length()
// S: O(MN) // M is word1.length(), N is word2.length()


class Solution {

    /** Return the min num of ops to convert word1 to word2
      * ops: insert a char; del a char; change a char */
    public int minDistance(String word1, String word2) {
        // const
        int M = word1.length();
        int N = word2.length();
        // DS:dp-table
        int[][] dp = new int[M+1][N+1];
        // base case
        for (int first = 1; first <= M; first++)
            dp[first][0] = first;
        for (int second = 1; second <= N; second++)
            dp[0][second] = second;
        // state transfer
        for (int first = 1; first <= M; first++) {
            for (int second = 1; second <= N; second++) {
                if (word1.charAt(first-1) == word2.charAt(second-1)) {
                    dp[first][second] = dp[first-1][second-1];
                } else {
                    dp[first][second] = min3(
                        dp[first-1][second] + 1, // del one char from word1
                        dp[first][second-1] + 1, // insert one char into word1
                        dp[first-1][second-1] + 1 // replace one char of word1
                    );
                }
            }
        }
        // return res
        return dp[M][N];
    }

    // support method
    private int min3(int x, int y, int z) {
        return Math.min(x, Math.min(y, z));
    }

}
