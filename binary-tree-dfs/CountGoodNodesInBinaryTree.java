/** Return the num of good nodes in a binary tree
  * good node: path from root to node has no value greater than node (root always is) */
public class CountGoodNodesInBinaryTree { // leetcode 1448
    // fields
    private int numGood = 0;
    // dfs-traverse + field-values
    public int goodNodes(TreeNode root) { // T: O(N), S: O(N).
        // dfs
        dfs(root, Integer.MIN_VALUE);
        // return
        return numGood;
    }
    private void dfs(TreeNode node, int pathMax) {
        // base case
        if (node == null)
            return;
        // pre-order
        if (node.val >= pathMax) {
            ++numGood;
            pathMax = node.val;
        }
        // traverse
        dfs(node.left, pathMax);
        dfs(node.right, pathMax);
    }
}
