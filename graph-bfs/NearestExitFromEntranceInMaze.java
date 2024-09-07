import java.util.Queue;
import java.util.LinkedList;

/** Return the num of steps in shortest path from entrance to nearest exit, or -1
  * m x n matrix maze, '.' is empty cell and '+' is wall, entrance[] is init [row, col]
  * exit is defined as an empty cell at border of maze */
public class NearestExitFromEntranceInMaze { // leetcode 1926
    // fields
    private final int[][] DIRS = new int[][]{ {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
    // bfs + adj-mat
    public int nearestExit(char[][] maze, int[] entrance) { // T: O(MN), S: O(M+N).
        // constants
        int M = maze.length;
        int N = maze[0].length;
        // data structures
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[M][N];
        // variables
        int step = 0;
        // init
        int startRow = entrance[0];
        int startCol = entrance[1];
        q.offer(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;
        // bfs
        while (!q.isEmpty()) {
            // count level
            int sz = q.size();
            ++step;
            // loop level
            for (int i = 0; i < sz; i++) {
                // poll
                int[] cur = q.poll();
                int curRow = cur[0];
                int curCol = cur[1];
                // dirs up/down/left/right
                for (int[] DIR : DIRS) {
                    int adjRow = curRow + DIR[0];
                    int adjCol = curCol + DIR[1];
                    if (adjRow < 0 || adjRow >= M 
                            || adjCol < 0 || adjCol >= N
                            || visited[adjRow][adjCol] || maze[adjRow][adjCol] == '+')
                        continue;
                    if (adjRow == 0 || adjRow == M-1 || adjCol == 0 || adjCol == N-1) // 
                        return step;
                    visited[adjRow][adjCol] = true;
                    // offer
                    q.offer(new int[]{adjRow, adjCol});
                }
            }
        }
        // return
        return -1;
    }
}
