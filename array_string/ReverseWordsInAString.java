// leetcode 151
// two-pointers:fast-slow
// T: O(N) // N: s.length() // two-pass
// S: O(N) // N: s.length()

class Solution {
    /** Reverse the order of words in string s, concatenated by one space
      * word: seq of non-space chars, sep by at least one space */
    public String reverseWords(String s) {
        // pre
        StringBuilder sb = removeExtraSpaces(s);
        sb.reverse();
        // vars
        int N = sb.length();
        int fast = 0;
        int slow = 0; // word: [slow, fast]
        // two-pointers:fast-slow
        while (fast < N) {
            if (fast+1 == N-1 || sb.charAt(fast+1) == ' ') { // reach end or locate a word
                reverse(sb, slow, fast);
                fast += 2;
                slow = fast;
            } else {
                ++fast;
            }
        }
        // return
        return sb.toString();
    }

    /** Reverse the chars[] with [left, right] */
    private void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char charLeft = sb.charAt(left);
            char charRight = sb.charAt(right);
            sb.setCharAt(left, charRight);
            sb.setCharAt(right, charLeft);
            ++left;
            --right;
        }
    }

    /** Remove the extra spaces in String s and return */
    private StringBuilder removeExtraSpaces(String s) {
        // trim
        int start = 0;
        int last = s.length() - 1;
        while (start < s.length() && s.charAt(start) == ' ')
            ++start;
        while (last >= 0 && s.charAt(last) == ' ')
            --last;
        s = s.substring(start, last+1);
        if (s.length() == 0)
            return null;
        // del inner dup spaces
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i-1) == ' ' && s.charAt(i) == ' ')
                continue;
            sb.append(s.charAt(i));
        }
        return sb;
    }

    // support method
    private void swap(StringBuilder sb, int left, int right) {
        while (left < right) {
            char charLeft = sb.charAt(left);
            char charRight = sb.charAt(right);
            sb.setCharAt(left, charRight);
            sb.setCharAt(right, charLeft);
        }
    }
}
