import java.util.List;
import java.util.LinkedList;

/** Return valid unique comb in any order
  * comb: k nums sum up to n; only 1-9 are used; each number is used at most once */
public class Solution { // leetcode 216
    // fields
    private List<List<Integer>> combs = new LinkedList<>();
    private List<Integer> track = new LinkedList<>();
    private int K; // K elems in comb
    private int TGT; // elems of comb sum to TGT
    private final int[] DIGITS = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    // backtracking
    public List<List<Integer>> combinationSum3(int k, int n) { // T: O(N!), S: O(K).
        // constants
        TGT = n; // sum of elems in comb
        K = k; // num of elems in comb
        // backtrack
        backtrack(DIGITS, 0);
        // return
        return combs;
    }
    private void backtrack(int[] nums, int start) {
        // constants
        int N = nums.length;
        // base case
        if (track.size() == K) { // reaches leaf node
            int sum = 0;
            for (int elem : track)
                sum += elem;
            if (sum == TGT)
                combs.add(new LinkedList<>(track));
            return;
        }
        // backtracking
        for (int i = start; i < N; i++) {
            // make decision
            track.addLast(nums[i]);
            // next level
            backtrack(nums, i+1);
            // cancel decision
            track.removeLast();
        }
    }
}
