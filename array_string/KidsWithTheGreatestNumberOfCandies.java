// leetcode 1431
// array
// T: O(N) // N: num of elems in candies[] // two-pass
// S: O(1)

import java.util.List;
import java.util.ArrayList;

class Solution {
    /** Return a boolean[] where elem is true if giving i-th kid extraCandies makes him greatest num
      * candies[i]: num of candies of i-th kid */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // var
        int maxCandy = candies[0];
        for (int candy : candies)
            maxCandy = Math.max(maxCandy, candy);
        // res
        List<Boolean> res = new ArrayList<>(); // res[i]: true if candies[i]+extra is max
        // pass candies[]
        for (int candy : candies) {
            if (candy + extraCandies >= maxCandy)
                res.add(true);
            else
                res.add(false);
        }
        // return
        return res;
    }
}
