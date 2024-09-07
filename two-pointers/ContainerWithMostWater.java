/** Return the max water can store
  * height[i] is the height of pillar, two pillars forms a container */
public class Solution { // leetcode 11
    // two-pointers:left-right
    public int maxArea(int[] height) { // T: O(N), S: O(1).
        // constants
        int N = height.length;
        // variables
        int maxArea = 0;
        int left = 0;
        int right = N-1;
        // two pointers
        while (left < right) {
            // comp area
            int curWidth = right - left;
            int curHeight = Math.min(height[left], height[right]);
            int curArea = curWidth * curHeight;
            maxArea = Math.max(maxArea, curArea);
            // step pointers
            if (height[left] <= height[right])
                ++left;
            else
                --right;
        }
        // return
        return maxArea;
    }
}
