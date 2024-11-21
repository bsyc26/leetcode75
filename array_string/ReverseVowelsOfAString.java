// leetcode 345
// two-pointers:left-right
// T: O(N) // N: s.length()
// S: O(N) // N: s.length()

class Solution {
    // field
    private String VOWELS = "aeiouAEIOU";

    /** Reverse all vowels in String s and return it
      * vowels: 'a', 'e', 'i', 'o', 'u', with their upper cases */
    public String reverseVowels(String s) {
        // const
        int N = s.length();
        // res
        char[] chars = s.toCharArray();
        // vars
        int left = 0;
        int right = N-1;
        // two-pointers:left-right
        while (left < right) {
            // find next vowel pair
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
            // step ptrs
            ++left;
            --right;
        }
        // return
        return String.valueOf(chars);
    }
}
