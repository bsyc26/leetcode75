/** Return the largest string divides both str1 and str2
  * t divides s if s = mutiple t concatenated */
public class Solution { // leetcode 1071
    // two-pointers:parallel
    public String gcdOfStrings(String str1, String str2) { // T: O(M+N), S: O(M+N).
        // constants
        int LEN_1 = str1.length();
        int LEN_2 = str2.length();
        // variables
        StringBuilder sb = new StringBuilder();
        int pt1 = 0;
        int pt2 = 0;
        String maxGcdStr = "";
        // two pointers
        while (pt1 < LEN_1 && pt2 < LEN_2) {
            sb.append(str1.charAt(pt1));
            int sz = sb.length();
            if (sb.toString().repeat(LEN_1/sz).equals(str1) // use .equals() + .repeat()
                && sb.toString().repeat(LEN_2/sz).equals(str2)) { // is gcd
                maxGcdStr = sb.toString(); // update gcd
            }
            ++pt1;
            ++pt2;
        }
        // return
        return maxGcdStr;
    }

    // gcd + modulo
    public String gcdOfStrings(String str1, String str2) { // T: O(M+N), S: O(1).
        if (!(str1+str2).equals(str2+str1)) // edge case
            return "";
        int gcdLen = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdLen);
    }
    private int gcd(int x, int y) { // T: O(logMN)
        if (y == 0)
            return x;
        else
            return gcd(y, x%y);
    }
}
