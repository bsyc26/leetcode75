import java.util.HashMap;

/** Return the num of ways to tile an 2 x n board, modulo 10^9+7
  * two types of tiles: domino (2 x 1) or tromino, can rotate */
public class Solution { // leetcode 790
    // fields
    private final int MOD = 1_000_000_007;
    // data structures
    HashMap<Integer, Long> fMap = new HashMap<>();
    HashMap<Integer, Long> pMap = new HashMap<>();
    // dp-memo
    public int numTilings(int n) { // T: O(N), S: O(N).
        return (int)f(n);
    }
    private long f(int n) {
        // base case
        if (fMap.containsKey(n))
            return fMap.get(n);
        // variables
        long val;
        if (n == 1)
            val = 1L;
        else if (n == 2)
            val = 2L;
        else
            val = (f(n-1) + f(n-2) + 2*p(n-1)) % MOD;
        // update map
        fMap.put(n, val);
        // return
        return val;
    }
    private long p(int n) {
        // base case
        if (pMap.containsKey(n))
            return pMap.get(n);
        // variables
        long val;
        if (n == 2)
            val = 1L;
        else
            val = (p(n-1) + f(n-2)) % MOD;
        // update map
        pMap.put(n, val);
        // return
        return val;
    }
}
