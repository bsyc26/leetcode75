import java.util.Stack;
import java.util.ArrayList;

/** Return the decoded String of an encoded String
  * encode rule: num[str], num is the repeated time of str, format can be nested */
public class Solution { // leetcode 394
    // stack:two-stacks
    public String decodeString(String s) { // T: O(N), S: O(N).
        // variables
        StringBuilder curStr = new StringBuilder(); 
        int curNum = 0;
        // data structures
        Stack<Integer> numStk = new Stack<>();
        Stack<StringBuilder> strStk = new Stack<>();
        // scan comp
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                curNum = curNum*10 + (c-'0');
            } else if (c == '[') {
                // push patterns
                numStk.push(curNum);
                strStk.push(curStr);
                // reset states
                curStr = new StringBuilder();
                curNum = 0;
            } else if (c == ']') {
                // pop patterns
                StringBuilder lastStr = strStk.pop();
                int deNum = numStk.pop();
                // update states
                lastStr.append(curStr.toString().repeat(deNum)); // ! append is essential
                curStr = lastStr;
            } else {
                curStr.append(c);
            }
        }
        // return
        return curStr.toString();
    }
}
