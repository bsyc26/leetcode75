// leetcode 443
// String
// T: O(N) // N: chars.length
// S: O(1)

class Solution {
    /** Return the compressed len of new arr and modify in-place
      * for consecutive repeating chars in chars[], append char followed by freq (also char) */
    public int compress(char[] chars) {
        // const
        int N = chars.length;
        // var
        int i = 0;
        // res
        int len = 0;
        while (i < N) {
            char c = chars[i];
            int count = 0; // freq of char is at least 1
            while (i < N && chars[i] == c) {
                ++i;
                ++count;
            }
            // mod in-place
            chars[len++] = c;
            if (count > 1) {
                for (char d : String.valueOf(count).toCharArray())
                    chars[len++] = d;
            }
        }
        // return
        return len;
    }
}
