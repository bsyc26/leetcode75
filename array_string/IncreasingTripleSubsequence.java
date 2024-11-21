// leetcode 334
// array
// T: O(N) // N: num of elems in nums[]
// S: O(1)

class Solution {
    /** Return true if existing triple of strictly increasing indices with strictly increasing values */
    public boolean increasingTriplet(int[] nums) {
        // edge case
        if (N < 3)
            return false;
        // vars
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        // pass nums[]
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min1)
                min1 = nums[i];
            else if (nums[i] <= min2) // fall-through of if
                min2 = nums[i];
            else
                return true;
        }
        // return fallback
        return false;
    }
}
