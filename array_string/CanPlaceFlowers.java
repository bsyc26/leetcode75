import java.util.Arrays;

/** Return true if n flowers can be planted into flowerbed[] without adjacent 
  * flowerbed[]: elem being 0 (empty) or 1 (occupied) */
public class Solution { // leetcode 605
    // one-pointer:modify
    public boolean canPlaceFlowers(int[] flowerbed, int n) { // T: O(N), S: O(N).
        // constants
        int N = flowerbed.length;
        // variables
        int maxPlant = 0;
        int[] arr = Arrays.copyOf(flowerbed, N);
        // scan modify
        for (int i = 0; i < N; i++) {
            if (arr[i] == 0) { // primary cond
                int leftLoc = (i == 0) ? 0 : arr[i-1];
                int rightLoc = (i == N-1) ? 0 : arr[i+1];
                if (leftLoc == 0 && rightLoc == 0) { // secondary cond
                    arr[i] = 1;
                    ++maxPlant;
                }
            }
        }
        // return
        return n <= maxPlant;
    }
}
