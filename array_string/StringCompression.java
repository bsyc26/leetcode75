/** Return the compressed len of new arr and modify in-place
  * for consecutive repeating chars (freq > 1) in chars[], append char followed by freq (also char)
  * S: O(1) */
public class StringCompression { // leetcode 443
    // one-pointer:modify
    public int compress(char[] chars) { // T: O(N), S: O(1).
        // constants
        int N = chars.length;
        // variables
        int idx = 0;
        int len = 0;
        // one-pointer
        while (idx < N) {
            int cnt = 1; // repetition of char, at least 1
            while (idx+cnt < N && chars[idx+cnt] == chars[idx])
                ++cnt;
            chars[len++] = chars[idx]; // fill char in-place
            if (cnt > 1)
                for (char digit : Integer.toString(cnt).toCharArray()) // convert cnt to char[]
                    chars[len++] = digit;
            idx += cnt; // idx points to next char
        }
        // return
        return len;
    }
}
