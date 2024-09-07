import java.util.List;
import java.util.ArrayList;

/** Return a boolean[] where elem is true if giving i-th kid extraCandies makes him greatest num
  * candies[i]: num of candies i-th kid has */
public class Solution { // leetcode 1431
    // one-pointer:compare
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) { // T: O(N), S: O(1).
        // constants
        int N = candies.length;
        // variables
        int maxCandy = candies[0];
        for (int candy : candies)
            maxCandy = Math.max(maxCandy, candy);
        List<Boolean> canMaxIfExtra = new ArrayList<>();
        // scan compare
        for (int candy : candies) {
            if (candy+extraCandies >= maxCandy)
                canMaxIfExtra.add(true);
            else
                canMaxIfExtra.add(false);
        }
        // return
        return canMaxIfExtra;

    }
}
