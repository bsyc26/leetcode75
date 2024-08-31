/** Return the max num of consecutive 1's with fliping at most k 0's */
public class MaxConsecutiveOnesIII { // leetcode 1004
    // sliding-window
    public int longestOnes(int[] nums, int k) { // T: O(N), S: O(1).
        // constants
        int N = nums.length;
        // variables
        int left = 0;
        int right = 0;
        int winFlip = 0; // num of 0's flipped into 1's in window
        int max1s = 0;
        // sliding window
        while (right < N) {
            // step right
            if (nums[right] == 0)
                ++winFlip;
            ++right;
            // manage states
            if (winFlip <= k)
                max1s = Math.max(max1s, right-left);
            // step left
            while (winFlip > k) {
                if (nums[left] == 0)
                    --winFlip;
                ++left;
            }
        }
        // return
        return max1s;
    }
}
