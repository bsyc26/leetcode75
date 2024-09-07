import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/** Return the min num of re-orienting roads to make every city visit city 0
  * connections[a, b] represents a road from a to b */
public class Solution { // leetcode 1466
    // dfs + adj-list
    public int minReorder(int n, int[][] connections) { // T: O(V), S: O(VE).
        // constants
        int V = n; // num of vertex
        // data structures
        List<Integer>[] graph = new List[V];
        for (int i = 0; i < V; i++)
            graph[i] = new ArrayList<>();
        for (int[] edge : connections) {
            int from = edge[0];
            int to = edge[1];
            graph[from].add(to);
            graph[to].add(-from); // rev dirt
        }
        // return
        return dfs(graph, 0, -1);
    }
    private int dfs(List<Integer>[] graph, int cur, int pred) {
        // variables
        int cnt = 0;
        // dfs
        for (int adj : graph[cur]) {
            if (Math.abs(adj) == pred)
                continue;
            if (adj > 0) // 0 <- .. <- pred <- cur <- adj
                ++cnt;
            cnt += dfs(graph, Math.abs(adj), cur);
        }
        // return
        return cnt;
    }
}
