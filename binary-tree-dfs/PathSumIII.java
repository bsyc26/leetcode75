import java.util.HashMap;

/** Return the num of paths (any branch) sum up to targetSum*/
public class Solution { // leetcode 437
    // fields
    // data structures
    private HashMap<Long, Integer> preSumMap = new HashMap<>();
    private long pathSum = 0;
    private int numPath = 0;
    private int tgtSum; // path: preSum[i] - preSum[j] == tgtSum (i < j)
    // dfs-traverse + prefix-sum + hash-map
    public int pathSum(TreeNode root, int targetSum) {
        // edge case
        if (root == null)
            return 0;
        // variables
        tgtSum = targetSum;
        // data structures
        preSumMap.put((long)0, 1); // init prefix-sum
        // dfs
        dfs(root);
        // return
        return numPath;
    }
    private void dfs(TreeNode node) {
        // base case
        if (node == null)
            return;
        // pre-order
        pathSum += node.val;
        numPath += preSumMap.getOrDefault(pathSum-tgtSum, 0);
        preSumMap.put(pathSum, preSumMap.getOrDefault(pathSum, 0)+1);
        // traverse
        dfs(node.left);
        dfs(node.right);
        // post-order
        preSumMap.put(pathSum, preSumMap.get(pathSum)-1);
        pathSum -= node.val;
    }
}
