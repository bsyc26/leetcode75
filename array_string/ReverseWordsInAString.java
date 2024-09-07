import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.ArrayDeque;

/** Reverse the order of words in string s, concatenated by one space
  * word: seq of non-space chars, sep by at least one space */
public class Solution { // leetcode 151
    // two-pointers:slow-fast
    public String reverseWords(String s) { // T: O(N), S: O(N).
        // variables
        String trim = s.trim(); // remove leading/trailing spaces
        StringBuilder sb = new StringBuilder();
        for (int i = trim.length()-1; i >= 0; i--) { // reverse all chars
            if (i < trim.length()-1
                    && trim.charAt(i) == ' '
                    && trim.charAt(i+1) == ' ') // jump mutiple sep spaces
                continue;
            else
                sb.append(trim.charAt(i));
        }
        int sz = sb.length();
        char[] chars = sb.toString().toCharArray();
        int slow = 0;
        int fast = 0;
        // two pointers
        while (slow < sz && fast < sz) {
            if (fast+1 == sz || chars[fast+1] == ' ') { // range a word or reach end
                reverseWords(chars, slow, fast);
                fast += 2;
                slow = fast;
            } else {
                ++fast;
            }
        }
        // return
        return String.valueOf(chars);
    }
    private void reverseWords(char[] chars, int left, int right) { // reverse [left, right]
        // two pointers
        while (left < right) {
            // swap char
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            // update pointers
            ++left;
            --right;
        }
    }

    // built-in
    public String reverseWords(String s) { // T: O(N), S: O(N).
        s = s.trim(); // remove leading/trailing spaces
        List<String> wordList = Arrays.asList(s.split("\\s+")); // split mutiple spaces
        Collections.reverse(wordList); // reverse order by words
        return String.join(" ", wordList); // concatenate words with one space
    }

    // deque
    public String reverseWords(String s) { // T: O(N), S: O(N).
        // variables
        StringBuilder sbWord = new StringBuilder();
        int left = 0;
        int right = s.length() - 1;
        while (left <= right && s.charAt(left) == ' ') // jump leading spaces
            ++left;
        while (left <= right && s.charAt(right) == ' ') // jump trailing spaces
            --right;
        // data structures
        Deque<String> dq = new ArrayDeque<>();
        // push word into front of deque
        while (left <= right) {
            char ch = s.charAt(left);
            if (sbWord.length() != 0 && ch == ' ')  {
                dq.offerFirst(sbWord.toString()); // reversely add word by word
                sbWord.setLength(0); // clear StringBuilder
            } else if (ch != ' ') {
                sbWord.append(ch);
            }
            ++left;
        }
        dq.offerFirst(sbWord.toString()); // add the last word
        // return
        return String.join(" ", dq);
    }
}
