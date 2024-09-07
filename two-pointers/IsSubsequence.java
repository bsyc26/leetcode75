/** Return true if s is a sub seq of t
  * sub seq: can be formed by deleting some chars */
public class Solution { // leetcode 392
    // two-pointers:parallel
    public boolean isSubsequence(String s, String t) { // T: O(N), S: O(1).
        // constants
        int LEN_S = s.length();
        int LEN_T = t.length();
        // variables
        int ptS = 0;
        int ptT = 0;
        // two pointers
        while (ptS < LEN_S && ptT < LEN_T) {
            if (s.charAt(ptS) == t.charAt(ptT))
                ++ptS;
            ++ptT;
        }
        // return
        return ptS == LEN_S;
    }
}
