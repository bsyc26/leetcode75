/** Return min int k can eat all bananas with h hours
  * piles[i] is num of bananas, k is the bananas-per-hour eating speed (no-overflow) */
public class Solution { // leetcode 875
    // binary-search
    public int minEatingSpeed(int[] piles, int h) { // T: O(NlogN), S: O(1).
        // constants
        int N = piles.length;
        // variables
        int left = 1;
        int right = 1; // piles[i] >= 1
        for (int pile : piles)
            right = Math.max(right, pile);
        // binary search
        while (left < right) {
            int mid = left + (right-left)/2;
            int curH = 0;
            for (int pile : piles)
                curH += Math.ceil((double)pile/mid);
            // comp cur with given
            if (curH <= h)
                right = mid;
            else
                left = mid+1;
        }
        // return
        return right;
    }
}
