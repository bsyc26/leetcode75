/** Return the max num of vowel char in substring with len k */
public class MaximumNumberOfVowelsInASubStringOfGivenLength { // leetcode 1456
    // fields
    private final String VOWELS = "aeiou";
    // sliding-window
    public int maxVowels(String s, int k) { // T: O(N), S: O(1).
        // constants
        int N = s.length();
        // variables
        int left = 0;
        int right = 0;
        int winVow = 0;
        int maxVow = 0;
        // sliding window
        while (right < N) {
            // step right
            char rightChar = s.charAt(right);
            if (VOWELS.indexOf(rightChar) != -1)
                ++winVow;
            ++right;
            // manage states
            if (right-left == k)
                maxVow = Math.max(maxVow, winVow);
            // step left
            while (right-left >= k) {
                char leftChar = s.charAt(left);
                if (VOWELS.indexOf(leftChar) != -1)
                    --winVow;
                ++left;
            }
        }
        // return
        return maxVow;
    }
}
