import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

/** Return the num of pairs (row, col) where the row[] equals the col[] */
public class EqualRowAndColumnPairs { // leetcode 2352
    // hash-set + string-compress
    public int equalPairs(int[][] grid) { // T: O(N2), S: O(N).
        // constants
        int N = grid.length;
        // varaibles
        int pairCnt = 0;
        // data structures
        Map<String, Integer> rowCntMap = new HashMap<>();
        for (int[] row : grid) { 
            String rowStr = Arrays.toString(row); // convert int[] into String for hash
            rowCntMap.put(rowStr, rowCntMap.getOrDefault(rowStr,0)+1);
        }
        // compare col[] with rowCntMap
        for (int col = 0; col < N; col++) {
            int[] colArr = new int[N];
            for (int row = 0; row < N; row++)
                colArr[row] = grid[row][col];
            String colStr = Arrays.toString(colArr);
            int cnt = rowCntMap.getOrDefault(colStr, 0);
            pairCnt += cnt;
        }
        // return
        return pairCnt;
    }
}
