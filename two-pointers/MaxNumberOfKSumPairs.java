import java.util.Arrays;

/** Return the max num of ops can perform on nums[]
  * one ops: remove two num sum equals k */
public class Solution { // leetcode 1679
    // two-pointers:left-right + sort
    public int maxOperations(int[] nums, int k) { // T: O(NlogN), S: O(N).
        // constants
        int N = nums.length;
        int TGT = k;
        // variables
        int[] arr = Arrays.copyOf(nums, N);
        Arrays.sort(arr);
        int left = 0;
        int right = N-1;
        int cnt = 0; // num of remove ops
        // two pointers
        while (left < right) {
            long curSum = arr[left] + arr[right];
            if (curSum > TGT) {
                --right;
            } else if (curSum < TGT) {
                ++left;
            } else { // curSum == TGT
                --right;
                ++left;
                ++cnt;
            }
        }
        // return
        return cnt;
    }
}
