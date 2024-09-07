import java.util.Arrays;

/** Return an int[] where elem is the num of pair successful with i-th spell
  * successful pair if spells[i] * potions[j] is at least success */
public class Solution { // leetcode 2300
    // binary-search:left-right-bound
    public int[] successfulPairs(int[] spells, int[] potions, long success) { // T: O(NlogN), S: O(N).
        // constants
        int LEN_S = spells.length;
        int LEN_P = potions.length;
        // variables
        int[] arrP = Arrays.copyOf(potions, LEN_P);
        Arrays.sort(arrP);
        int maxP = arrP[LEN_P-1]; // for boundary check
        int[] numPairs = new int[LEN_S]; // elem is num successful pairs of spells[i]
        // loop spells
        for (int i = 0; i < LEN_S; i++) {
            int curS = spells[i];
            long minP = (long)Math.ceil((1.0*success)/curS); // calc min succ val of potion
            if (minP > maxP) { // boundary check
                numPairs[i] = 0;
                continue;
            } else { 
                int idxP = lowerBound(arrP, (int)minP);
                numPairs[i] = LEN_P - idxP;
            }
        }
        // return
        return numPairs;
    }
    private int lowerBound(int[] arr, int tgt) {
        // constants
        int N = arr.length;
        // variables
        int lo = 0;
        int hi = N-1;
        // binary search
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if (arr[mid] < tgt)
                lo = mid+1;
            else if (arr[mid] > tgt)
                hi = mid-1;
            else
                hi = mid-1;
        }
        // return
        return lo;
    }
}
