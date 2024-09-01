/** Find the lowest common ancestor (LCA) of two given nodes in a tree
  * LCA: lowest depth node being the ancestor of both nodes, can be one of themselves */
public class LowestCommonAncestorOfABinaryTree { // leetcode 236
    // dfs-division + return-values
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) { // T: O(N), S: O(1).
        return dfs(root, p.val, q.val);
    }
    private TreeNode dfs(TreeNode node, int val1, int val2) {
        // base case
        if (node == null)
            return null;
        // pre-order
        if (node.val == val1 || node.val == val2) // if val matches return cur node
            return node;
        // division
        TreeNode left = dfs(node.left, val1, val2);
        TreeNode right = dfs(node.right, val1, val2);
        // post-order
        if (left != null && right != null) // cur node is the LCA
            return node;
        // return fallback
        return (left == null) ? right : left; // cur node contains a child node in sub
    }
}
