// leetcode 1143
// dp-nd:memo
// T: (MN) // M is text1.length(), N is text2.length()
// S: (MN) // M is text1.length(), N is text2.length()

import java.util.Arrays;

class Solution {

    // field
    private int[][] memo; // DS:dp-table

    /** Return the len of longest common subseq of String text1 and text2 */
    public int longestCommonSubsequence(String text1, String text2) {
        // const
        int M = text1.length();
        int N = text2.length();
        // field
        memo = new int[M][N];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        // return dp
        return dp(text1, 0, text2, 0);
    }
    
    /** Return the len of longest common subseq of text1[first..] and text2[second..] */
    private int dp(String str1, int first, String str2, int second) {
        // base case
        if (first == str1.length() || second == str2.length())
            return 0;
        // jump memo
        if (memo[first][second] != -1)
            return memo[first][second];
        // state transfer
        if (str1.charAt(first) == str2.charAt(second)) {
            memo[first][second] = 1 + dp(str1, first+1, str2, second+1);
        } else {
            memo[first][second] = Math.max(
                dp(str1, first+1, str2, second),
                dp(str1, first, str2, second+1)
            );
        }
        // return res
        return memo[first][second];
    }

}
