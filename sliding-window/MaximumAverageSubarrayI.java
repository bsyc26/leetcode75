/** Find a subarray with k len has max avg and return this avg */
public class MaximumAverageSubarrayI { // leetcode 643
    // sliding-window
    public double findMaxAverage(int[] nums, int k) { // T: O(N), S: O(1).
        // constants
        int N = nums.length;
        // variables
        int left = 0;
        int right = 0;
        double maxSum = Integer.MIN_VALUE;
        double winSum = 0;
        // sliding window 
        while (right < N) {
            // step right
            winSum += nums[right];
            ++right;
            // manage states
            if (right-left == k)
                maxSum = Math.max(maxSum, winSum);
            // step left
            while (right-left >= k) {
                winSum -= nums[left];
                ++left;
            }
        }
        // return
        return maxSum/k;
    }
}
