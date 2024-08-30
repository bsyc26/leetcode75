/** Return the merged string
  * merge in alter order, longer part is append to the end */
public class MergeStringAlternately { // leetcode 1768
    // two-pointers:parallel
    public String mergeAlternately(String word1, String word2) { // T: O(M+N), S: O(1).
        // constants
        int N1 = word1.length();
        int N2 = word2.length();
        // variables
        StringBuilder sb = new StringBuilder();
        int p1 = 0;
        int p2 = 0;
        // two-pointers
        while (p1 < N1 && p2 < N2) {
            sb.append(word1.charAt(p1));
            sb.append(word2.charAt(p2));
            ++p1;
            ++p2;
        }
        // cope with the left
        while (p1 < N1) {
            sb.append(word1.charAt(p1));
            ++p1;
        }
        while (p2 < N2) {
            sb.append(word2.charAt(p2));
            ++p2;
        }
        // return
        return sb.toString();
    }

    // one-pointer:update
    public String mergeAlternately(String word1, String word2) { // T: O(M+N), S: O(1).
        // constants
        int N1 = word1.length();
        int N2 = word2.length();
        // variables
        StringBuilder sb = new StringBuilder();
        // one-pointer
        for (int i = 0; i < Math.max(N1, N2); i++) {
            if (i < N1)
                sb.append(word1.charAt(i));
            if (i < N2)
                sb.append(word2.charAt(i));
        }
        // return
        return sb.toString();
    }
}
