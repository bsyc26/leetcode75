/** Move all 0's to the end of nums[] while maintaining other elems */
public class MoveZeros { // leetcode 283
    // two-pointers:fast-slow
    public void moveZeros(int[] nums) { // T: O(N), S: O(1).
        // constants
        int N = nums.length;
        // variables
        int fast = 0;
        int slow = 0;
        // two-pointers
        while (fast < N && slow < N) {
            while (fast+1 < N && nums[fast] == 0) // jump all 0's
                ++fast;
            nums[slow] = nums[fast];
            ++fast;
            ++slow;
        }
        // fill-in 0's in the end
        for (; slow < N; slow++)
            nums[slow] = 0;
    }
}
