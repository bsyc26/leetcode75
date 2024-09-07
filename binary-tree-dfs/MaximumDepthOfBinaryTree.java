/** Return max depth of a binary tree (1-indexed) */
public class Solution { // leetcode 104
    // dfs-division + return-values
    public int maxDepth(TreeNode root) { // T: O(N), S: O(1).
        // edge case
        if (root == null)
            return 0;
        // return
        return dfs(root);
    }
    private int dfs(TreeNode node) {
        // base case
        if (node == null)
            return 0;
        // division
        int leftMax = dfs(node.left);
        int rightMax = dfs(node.right);
        // return
        return 1 + Math.max(leftMax, rightMax);
    }
}
