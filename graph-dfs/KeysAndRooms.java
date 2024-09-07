import java.util.List;
import java.util.ArrayList;

/** Return true if you can visit all room
  * room 0 is open, room[1..n-1] is locked, room[i] is the keys in room */
public class Solution { // leetcode 841
    // fields
    // data structures
    boolean[] visited;
    // dfs + adj-list
    public boolean canVisitAllRooms(List<List<Integer>> rooms) { // T: O(N), S: O(N).
        // constants
        int V = rooms.size();
        // data structures
        visited = new boolean[V];
        // dfs
        dfs(rooms, 0);
        // return
        for (int i = 0; i < V; i++)
            if (!visited[i])
                return false;
        return true;
    }
    private void dfs(List<List<Integer>> graph, int id) {
        // base case
        if (visited[id])
            return;
        // pre-order
        visited[id] = true;
        // traverse
        for (int adjId : graph.get(id))
            dfs(graph, adjId);
    }
}
