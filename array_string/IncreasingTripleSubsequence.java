/** Return true if existing triple of strictly increasing indices with strictly increasing values */
public class Solution { // leetcode 334
    // one-pointer:compare
    public boolean increasingTriplet(int[] nums) { // T: O(N), S: O(1).
        // constants
        int N = nums.length;
        // edge case
        if (N < 3)
            return false;
        // variables
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        // scan compare
        for (int i = 0; i < N; i++) {
            if (nums[i] <= min1) // guarantee a min1 with smaller idx and val than min2
                min1 = nums[i]; // even after updating min1
            else if (nums[i] <= min2)
                min2 = nums[i];
            else
                return true; // val: nums[i] > min2 > ? > min1, idx: i > min2_i > ?_i
        }
        // return fallback
        return false;
    }
}
