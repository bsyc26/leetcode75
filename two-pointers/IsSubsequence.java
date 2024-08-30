/** Return true if s is a sub seq of t
  * sub seq: can be formed by deleting some chars */
public class IsSubsequence { // leetcode 392
    // two-pointers:parallel
    public boolean isSubsequence(String s, String t) { // T: O(N), S: O(1).
        // constants
        int LEN_S = s.length();
        int LEN_T = t.length();
        // variables
        int ptrS = 0;
        int ptrT = 0;
        // two-pointers
        while (ptrS < LEN_S && ptrT < LEN_T) {
            if (s.charAt(ptrS) == t.charAt(ptrT))
                ++ptrS;
            ++ptrT;
        }
        // return
        return ptrS == LEN_S;
    }
}
