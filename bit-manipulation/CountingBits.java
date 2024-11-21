// leetcode 338
// bit-map:pop-count
// T: O(NlogN)
// S: O(1)

class Solution { // x &= x-1 // flip the rightmost 1 into 0

    /** Return an arr[n+1] where arr[i] is num of 1's in binary representation of i*/
    public int[] countBits(int n) {
        // res
        int[] res = new int[n+1];
        for (int i = 0; i <= n; i++)
            res[i] = popCount(i);
        // return res
        return res;
    }

    /** Return the count of reducing x to all 0 bits */
    private int popCount(int x) {
        // res
        int count = 0;
        // reduce 0 in x && count
        while (x != 0) {
            x &= x - 1; // make the least significant 1 bit to 0
            ++count;
        }
        // return res
        return count;
    }

}

// follow-up
// bit-map:pop-count + dp
// T: O(N)
// S: O(1)

class Solution {

    /** Return an arr[n+1] where arr[i] is num of 1's in binary representation of i*/
    public int[] countBits(int n) {
        // DS:dp-table
        int[] dp = new int[n+1];
        dp[0] = 0;
        // state transfer
        for (int i = 1; i <= n; i++) {
            int x = i & (i-1); // last set bit (rightmost) to 0
            dp[i] = dp[x] + 1;
        }
        // return res
        return dp;
    }

}
