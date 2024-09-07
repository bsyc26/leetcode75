import java.util.Arrays;

/** Return an int[] of len n where elem is num of potions pair with i-th spell
  * spells[i], postions[j], pair is success if product of them at least success */
public class SuccessfulPairsOfSpellsAndPotions { // leetcode 2300
    // binary-search
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        // constants
        int LEN_S = spells.length;
        int LEN_P = potions.length;
        // copy arr
        int[] arrS = Arrays.copyOf(LEN_S, spells);
        int[] arrP = Arrays.copyOf(LEN_P, potions);
        // variables
        int[] numPairs = new int[LEN_S];
        // binary search
        for (int i = 0; i < LEN_S; i++) {
            int s = arrS[i];
        }
    }
    private int lowBound(int[] arr, int target) {
        // constants
        int N = arr.length;
        // variables
        int lo = 0;
        int hi = N-1;
        // binary search
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if (arr[mid] < target)
                lo = mid+1;
            else if (arr[mid] > target)
                hi = mid-1; 
            else
                hi = mid-1;
        }
        // return fallback
        return lo;
    }
}
