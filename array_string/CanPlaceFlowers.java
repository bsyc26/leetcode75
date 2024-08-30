/** Return true if n flowers can be planted into flowerbed[] without adjacent 
  * flowerbed[]: elem being 0 (empty) or 1 (occupied) */
public class CanPlaceFlowers { // leetcode 605
    // one-pointer:update
    public boolean canPlaceFlowers(int[] flowerbed, int n) { // T: O(N), S: O(N).
        // constants
        int N = flowerbed.length;
        // variables
        int maxPlant = 0;
        int[] copy = new int[N];
        for (int i = 0; i < N; i++)
            copy[i] = flowerbed[i];
        // one-pointer
        for (int i = 0; i < N; i++) {
            if (copy[i] == 0) { // primary cond
                int leftLoc = (i == 0) ? 0 : copy[i-1];
                int rightLoc = (i == N-1) ? 0 : copy[i+1];
                if (leftLoc == 0 && rightLoc == 0) { // secondary cond
                    copy[i] = 1;
                    ++maxPlant;
                }
            }
        }
        // return
        return n <= maxPlant;
    }
}
