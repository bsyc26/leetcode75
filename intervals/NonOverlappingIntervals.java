// leetcode 435
// greedy:interval-end + sort
// T: O(NlogN)
// S: O(N)

import java.util.Arrays;

class Solution {

    /** Return the min num of intv to remove to make remains non-overlapping */
    public int eraseOverlapIntervals(int[][] intervals) {
        // const
        int N = intervals.length;
        // vars
        int[][] sortedIntvs = new int[N][2];
        for (int i = 0; i < N; i++)
            sortedIntvs[i] = Arrays.copyOf(intervals[i], 2);
        Arrays.sort(sortedIntvs, (a, b) -> Integer.compare(a[1], b[1])); // increasing end
        int maxEnd = sortedIntvs[0][1];
        // res
        int uniq = 1;
        // greedy:interval-end
        for (int i = 1; i < N; i++) {
            int[] intv = sortedIntvs[i];
            int curStart = intv[0];
            int curEnd = intv[1];
            // case: no intersaction
            if (curStart >= maxEnd) {
                ++uniq;
                maxEnd = Math.max(maxEnd, curEnd);
            }
        }
        // return res
        return N - uniq;
    }

}
