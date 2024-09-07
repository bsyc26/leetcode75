import java.util.Queue;
import java.util.LinkedList;

/** Return the min num of minutes to rot all orange, -1 if impossible
  * m x n grid, grid[i]: 0 for empty, 1 for fresh, 2 for rotten
  * each minute any fresh will be rotten by 4-dirts */
public class Solution { // leetcode 994
    // fields
    private final int[][] DIRS = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    // bfs
    public int orangesRotting(int[][] grid) { // T: O(MN), S: O(MN).
        // constants
        int M = grid.length;
        int N = grid[0].length;
        // variables
        int numFresh = 0;
        int time = 0;
        // data structures
        Queue<int[]> q = new LinkedList<>();
        // init
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 2)
                    q.offer(new int[]{i, j});
                else if (grid[i][j] == 1)
                    ++numFresh;
            }
        }
        // bfs
        while (!q.isEmpty() && numFresh != 0) {
            // count level
            int sz = q.size();
            // loop level
            for (int i = 0; i < sz; i++) {
                // poll
                int[] cur = q.poll();
                int row = cur[0];
                int col = cur[1];
                // manage states
                for (int[] dir : DIRS) {
                    int adjRow = row + dir[0];
                    int adjCol = col + dir[1];
                    // offer
                    if (adjRow >= 0 && adjRow < M && adjCol >= 0 && adjCol < N) {
                        if (grid[adjRow][adjCol] == 1) {
                            grid[adjRow][adjCol] = 2;
                            --numFresh;
                            q.offer(new int[]{adjRow, adjCol});
                        }
                    }
                }
            }
            ++time; // step
        }
        // return
        return numFresh == 0 ? time : -1;
    }
}
