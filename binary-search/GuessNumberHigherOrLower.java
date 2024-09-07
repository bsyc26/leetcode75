/** Return the num pick between 1 to n */
public class GuessNumberHigherOrLower { // leetcode 374
    // binary search
    public int guessNumber(int n) { // T: O(logN), S: O(1).
        // variables
        int lo = 1;
        int hi = n;
        // binary-search
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            int comp = guess(mid);
            if (comp == 0)
                return mid;
            else if (comp == 1)
                lo = mid + 1;
            else // comp == -1
                hi = mid - 1;
        }
        // return
        return -1;
    }
}

public interface APIs {
    // return: -1 if guess higher, 1 if guess lower, 0 if guess equal
    public int guess(int num);
}
