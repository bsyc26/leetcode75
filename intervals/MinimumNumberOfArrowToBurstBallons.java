// leetcode 452
// greedy:interval-end + sort
// T: O(NlogN)
// S: O(N)

import java.util.Arrays;

class Solution {
    
    /** Return the min num of arrows to burst all balloons
      * arrow: shot up directly vertically burst all ballons if is within [start..end]
      * ballon: points[i] is [start, end] of ballon */
    public int findMinArrowShots(int[][] points) {
        // const
        int N = points.length;
        // vars
        int[][] sortedIntvs = new int[N][2];
        for (int i = 0; i < N; i++)
            sortedIntvs[i] = Arrays.copyOf(points[i], 2);
        Arrays.sort(sortedIntvs, (a, b) -> Integer.compare(a[1], b[1])); // increasing end
        int maxEnd = sortedIntvs[0][1];
        // res
        int minArrows = 1; // at least one arrow to burst the first intv
        // greedy:interval-end
        for (int[] intv : sortedIntvs) {
            int curStart = intv[0];
            int curEnd = intv[1];
            // case non-intersaction
            if (curStart > maxEnd) {
                ++minArrows;
                maxEnd = curEnd;
            }
        }
        // return res
        return minArrows;
    }

}
