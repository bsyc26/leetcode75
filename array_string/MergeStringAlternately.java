// leetcode 1768
// two-pointers:first-second
// T: O(M+N) // M: word1.length(), N: word2.length() // one-pass
// S: O(1)

class Solution {
    /** Return the merged string
      * merge in alter order, longer part is append to the end */
    public String mergeAlternately(String word1, String word2) {
        // const
        int N1 = word1.length();
        int N2 = word2.length();
        // vars
        int first = 0;
        int second = 0;
        // res
        StringBuilder sb = new StringBuilder();
        // two-pointers:first-second
        while (first < N1 && second < N2) {
            // parallel append
            if (first < N1)
                sb.append(word1.charAt(first));
            if (second < N2)
                sb.append(word2.charAt(second));
            // step ptrs
            ++first;
            ++second;
        }
        // tail op
        while (first < N1) {
            sb.append(word1.charAt(first));
            ++first;
        }
        while (second < N2) {
            sb.append(word2.charAt(second));
            ++second;
        }
        // return
        return sb.toString();
    }
}
