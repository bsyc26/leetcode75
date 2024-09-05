import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;

/** Return the ans to all queries, or -1.0
  * equations[i] = [A, B] and values[i] = A/B (double)
  * queries[i] = [C, D] ans is C/D */
public class EvaluateDivision { // leetcode 399
    // dfs + adj-list
    public double[] calcEquation( // T: O(VE), S: O(VE).
            List<List<String>> equations, double[] values, List<List<String>> queries) {
        // data structures
        Map<String, Map<String, Double>> graph = new HashMap<>(); // flex num of vet and edge
        for (int i = 0; i < equations.size(); i++) {
            // extract
            List<String> edge = equations.get(i);
            String from = edge.get(0);
            String to = edge.get(1);
            double weight = values[i];
            // update
            graph.putIfAbsent(from, new HashMap<>());
            graph.putIfAbsent(to, new HashMap<>());
            graph.get(from).put(to, weight);
            graph.get(to).put(from, 1.0/weight); 
        }
        // variables
        double[] resArr = new double[queries.size()];
        // eval queries
        for (int i = 0; i < queries.size(); i++) {
            // extract
            List<String> query = queries.get(i);
            String from = query.get(0);
            String to = query.get(1);
            // eval
            if (!graph.containsKey(from) || !graph.containsKey(to)) // no entry
                resArr[i] = -1.0;
            else if (graph.get(from).containsKey(to)) // existing res
                resArr[i] = graph.get(from).get(to);
            else 
                resArr[i] = dfs(graph, from, to, new HashSet<String>()); // dfs with new HashSet
        }
        // return
        return resArr;
    }
    private double dfs(
            Map<String, Map<String, Double>> graph, String from, String to, Set<String> visited) {
        // base case
        if (from.equals(to))
            return 1.0;
        // pre-order
        visited.add(from);
        // division
        for (String adj : graph.get(from).keySet()) {
            if (visited.contains(adj))
                continue;
            double res = dfs(graph, adj, to, visited); // search adj -> to
            if (res > 0)
                return res * graph.get(from).get(adj); // from/to = (from/adj) * ... * (adj/to)
        }
        // return fallback
        return -1.0;
    }
}
