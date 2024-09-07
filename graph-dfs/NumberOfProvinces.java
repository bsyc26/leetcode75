/** Return the tot num of provinces
  * province: connected cities
  * isConnected[i][j]: 1 means connected, 0 means not */
public class Solution { // leetcode 547
    // fields
    // data structures
    boolean[] visited;
    int numConn = 0;
    // dfs + adj-mat
    public int findCircleNum(int[][] isConnected) { // T: O(N2), S: O(N).
        // constants
        int V = isConnected.length;
        // data structures
        visited = new boolean[V];
        // dfs
        for (int i = 0; i < V; i++)
            dfs(isConnected, i);
        // return
        return V - numConn;
    }
    private void dfs(int[][] graph, int id) {
        // constants
        int V = graph.length;
        // pre-order
        visited[id] = true;
        // traverse
        for (int adj = 0; adj < graph.length; adj++) {
            if (!visited[adj] && graph[id][adj] == 1) {
                ++numConn;
                dfs(graph, adj);
            }
        }
    }
}
