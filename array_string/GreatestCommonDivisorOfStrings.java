// leetcode 1071
// two-pointers:first-second
// T: O(M+N) // M: str1.length(), N: str2.length()
// S: O(M+N) // M: str1.length(), N: str2.length()

class Solution {
    /** Return the largest string divides both str1 and str2
      * t divides s if s = mutiple t concatenated */
    public String gcdOfStrings(String str1, String str2) {
        // const
        int LEN_1 = str1.length();
        int LEN_2 = str2.length();
        // vars
        StringBuilder sb = new StringBuilder();
        int first = 0;
        int second = 0;
        // res
        String maxGcd = "";
        // two-pointers:first-second
        while (first < LEN_1 && second < LEN_2) {
            sb.append(str1.charAt(first));
            int curSize = sb.length();
            String curGcd = sb.toString();
            // match size
            if (LEN_1 % curSize == 0 && LEN_2 % curSize == 0) {
                // match repetition
                if (curGcd.repeat(LEN_1/curSize).equals(str1)
                        && curGcd.repeat(LEN_2/curSize).equals(str2))
                    maxGcd = curGcd;
            }
            ++first;
            ++second;
        }
        // return
        return maxGcd;
    }
}
