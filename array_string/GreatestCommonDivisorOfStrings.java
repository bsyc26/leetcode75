/** Return the largest string divides both str1 and str2
  * t divides s if s = mutiple t concatenated */
public class GreatestCommonDivisorOfStrings { // leetcode 1071
    // two-pointers:parallel
    public String gcdOfStrings(String str1, String str2) { // T: O(M+N), S: O(M+N).
        // constants
        int N1 = str1.length();
        int N2 = str2.length();
        // variables
        StringBuilder sb = new StringBuilder();
        int p1 = 0;
        int p2 = 0;
        String maxGcdStr = "";
        // two-pointers
        while (p1 < N1 && p2 < N2) {
            sb.append(str1.charAt(p1));
            int sz = sb.length();
            if (sb.toString().repeat(N1/sz).equals(str1) // use .equals() + .repeat()
                && sb.toString().repeat(N2/sz).equals(str2)) { // is gcd
                maxGcdStr = sb.toString(); // update gcd
            }
            ++p1;
            ++p2;
        }
        // return
        return maxGcdStr;
    }

    // gcd + modulo
    public String gcdOfStrings(String str1, String str2) { // T: O(M+N), S: O(M+N).
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
