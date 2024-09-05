import java.util.Queue;
import java.util.LinkedList;

/** Return the num of steps in shortest path from entrance to nearest exit, or -1
  * m x n matrix maze, '.' is empty cell and '+' is wall, entrance[] is init [row, col]
  * exit is defined as an empty cell at border of maze */
public class NearestExitFromEntranceInMaze { // leetcode 1926
    // fields
    private final int[][] DIRS = new int[][]{ {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
    // bfs + matrix
    public int nearestExit(char[][] maze, int[] entrance) { // T: O(MN), S: O(M+N).
        // variables
        int startRow = entrance[0];
        int startCol = entrance[1];
        maze[startRow][startCol] = '+';
        // return
        return bfs(maze, startRow, startCol);
    }
    private int bfs(char[][] mat, int row, int col) {
        // constants
        int M = mat.length;
        int N = mat[0].length;
        // data structures
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{ row, col, 0 }); // 0 is the dist from entrance
        // bfs
        while (!q.isEmpty()) {
            // poll
            int[] cur = q.poll();
            int curRow = cur[0];
            int curCol = cur[1];
            int curDist = cur[2];
            // loop neighbors
            for (int[] DIR : DIRS) {
                int nextRow = curRow + DIR[0];
                int nextCol = curCol + DIR[1];
                if (nextRow >= 0 && nextRow < M
                        && nextCol >= 0 && nextCol < N
                        && mat[nextRow][nextCol] == '.') { // next exists empty cell
                    if (nextRow == 0 || nextRow == M-1
                            || nextCol == 0 || nextCol == N-1) // next is exit
                        return 1 + curDist; // found exit
                    mat[nextRow][nextCol] = '+'; // make visited
                    q.offer(new int[]{ nextRow, nextCol, 1+curDist });
                }
            }
        }
        // return fallback
        return -1;
    }
}
