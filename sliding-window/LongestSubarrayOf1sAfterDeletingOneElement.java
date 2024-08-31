/** Return the max len of subarray containing only 1's, else 0
  * should delete one elem from nums[] */
public class LongestSubarrayOf1sAfterDeletingOneElement { // leetcode 1493
    // sliding-window
    public int longestSubarray(int[] nums) { // T: O(N), S: O(1).
        // constants
        int N = nums.length;
        // variables
        int del0s = 0;
        int left = 0;
        int right = 0;
        int maxLen = 0;
        // sliding window
        while (right < N) {
            // step right
            if (nums[right] == 0)
                ++del0s;
            ++right;
            // manage states
            if (del0s <= 1)
                maxLen = Math.max(maxLen, right-left-1); // must del one elem
            // step left
            while (del0s > 1) {
                if (nums[left] == 0)
                    --del0s;
                ++left;
            }
        }
        // return
        return maxLen;
    }
}
