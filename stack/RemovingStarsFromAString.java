import java.util.Stack;

/** Return the string after removing all '*'
  * remove op: remove the colsest non-star char to its left and star itself */
public class Solution { // leetcode 2390
    // stack
    public String removeStars(String s) { // T: O(N), S: O(N).
        // data structures
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*')
                stk.pop();
            else
                stk.push(s.charAt(i));
        }
        // variables
        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty())
            sb.append(stk.pop());
        // return
        return sb.reverse().toString();
    }
}
