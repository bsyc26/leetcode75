import java.util.Arrays;

/** Return the max num of ops can perform on nums[]
  * one ops: remove two num sum equals k */
public class MaxNumberOfKSumPairs { // leetcode 1679
    // two-pointers:left-right + sort
    public int maxOperations(int[] nums, int k) { // T: O(NlogN), S: O(N).
        // constants
        int N = nums.length;
        // variables
        int[] copy = Arrays.copyOf(nums, N);
        Arrays.sort(copy);
        int left = 0;
        int right = N-1;
        int cnt = 0; // num of remove ops
        // two-pointers
        while (left < right) {
            long curSum = copy[left] + copy[right];
            if (curSum > k) {
                --right;
            } else if (curSum < k) {
                ++left;
            } else {
                --right;
                ++left;
                ++cnt;
            }
        }
        // return
        return cnt;
    }
}
