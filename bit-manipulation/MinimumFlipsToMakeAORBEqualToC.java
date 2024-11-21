// leetcode 1318
// bit-map:
// T: O(N)
// S: O(1)

class Solution {

    /** Return the min flips of bits in a and b to make a OR b == c */
    public int minFlips(int a, int b, int c) {
        // res
        int count = 0;
        // pass bits of c
        while (a != 0 | b != 0 | c != 0) {
            // comp every bit of c with a and b
            if ((c & 1) == 1) {
                if ((a & 1) == 0 && (b & 1) == 0) // need flip one bit of a and b to be 1
                    count++;
            } else {
                count += (a & 1) + (b & 1); // need both a and b bits to be 0
            }
            // reduce all with the rightmost bit
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        // return res
        return count;
    }

}
