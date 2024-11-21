// leetcode 605
// array
// T: O(N) // N: num of elems in flowerbed[]
// S: O(1) // in-place mod

class Solution {
    /** Return true if n flowers can be planted into flowerbed[] without adjacent 
      * flowerbed[]: elem being 0 (empty) or 1 (occupied) */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // vars
        int maxPlant = 0;
        // pass flowerbed[]
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                int valLeft = (i == 0) ? 0 : flowerbed[i-1];
                int valRight = (i == N-1) ? 0 : flowerbed[i+1];
                // case: can plant
                if (valLeft == 0 && valRight == 0) {
                    flowerbed[i] = 1;
                    ++maxPlant;
                }
            }
        }
        // return
        return n <= maxPlant;
    }
}
