/** Reverse all vowels in String s and return it
  * vowels: 'a', 'e', 'i', 'o', 'u' */
public class ReverseVowelsOfAString { // leetcode 345
    // fields
    private String VOWELS = "aeiouAEIOU";
    // two-pointers:left-right
    public String reverseVowels(String s) { // T: O(N), S: O(1).
        // constants
        int N = s.length();
        // variables
        char[] chars = s.toCharArray();
        int left = 0;
        int right = N-1;
        // two-pointers
        while (left < right) {
            // find next couple of vowels
            while (left < N && VOWELS.indexOf(chars[left]) < 0)
                ++left;
            while (right >= 0 && VOWELS.indexOf(chars[right]) < 0)
                --right;
            // swap vowels
            if (left < right) {
                char tmp = chars[left];
                chars[left] = chars[right];
                chars[right] = tmp;
            }
            // step pointers
            ++left;
            --right;
        }
        // return
        return String.valueOf(chars);
    }
}
