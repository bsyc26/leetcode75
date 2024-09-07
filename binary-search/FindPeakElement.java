/** Return the idx of the peak elem (any if mutiple)
  * peak elem: strictly larger than its neighbor, nums[-1] = nums[N] = -inifity
  * T: O(logN) */
public class FindPeakElement { // leetcode 162
    // binary-search
    public int findPeakElement(int[] nums) { // T: O(logN), S: O(1).
        // constants
        int N = nums.length;
        // variables
        int left = 0;
        int right = N-1;
        // binary search
        while (left < right) { // left == right is the peak elem idx
            int mid = left + (right-left)/2;
            if (nums[mid] > nums[mid+1])
                right = mid;
            else
                left = mid+1;
        }
        // return
        return left;
    }
}
