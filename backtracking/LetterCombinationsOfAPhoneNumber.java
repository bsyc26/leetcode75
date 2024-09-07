import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/** Return all possible comb of letters in any order
  * 2:abc, 3:def, 4:ghi, 5:jkl, 6:mno, 7:pqrs, 8:tuv, 9:wxyz */
public class Solution { // leetcode 17
    // fields
    // data structures
    private List<String> combs = new ArrayList<>();
    private Map<Character, String> MAP = Map.of(
            '2', "abc",
            '3', "def",
            '4', "ghi",
            '5', "jkl",
            '6', "mno",
            '7', "pqrs",
            '8', "tuv",
            '9', "wxyz"
    );
    private String digits;
    // backtracking
    public List<String> letterCombinations(String digits) { // T: O(2^N), S: O(N).
        // edge case
        if (digits.length() == 0)
            return combs;
        // variables
        this.digits = digits;
        backtrack(0, new StringBuilder());
        // return
        return combs;
    }
    private void backtrack(int idx, StringBuilder sb) {
        // base case
        if (sb.length() == digits.length()) {
            combs.add(sb.toString());
            return;
        }
        // variables
        String letters = MAP.get(digits.charAt(idx));
        // backtracking
        for (char letter : letters.toCharArray()) {
            // make decision
            sb.append(letter);
            // next level
            backtrack(1+idx, sb);
            // cancel decision
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
