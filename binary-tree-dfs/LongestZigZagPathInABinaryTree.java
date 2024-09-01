/** Return the longest ZigZag path in given binary tree
  * ZigZag path: switch direction at each level, len is num of nodes - 1 */
public class LongestZigZagPathInABinaryTree { // leetcode 1372
    // fields
    private int maxZigZagLen = 0;
    // dfs-division + return-values
    public int longestZigZag(TreeNode root) { // T: O(N), S: O(1).
        // edge case
        if (root == null)
            return 0;
        // dfs
        dfs(root);
        // return
        return maxZigZagLen;
    }
    private int[] dfs(TreeNode node) {
        // base case
        if (node == null)
            return new int[]{ -1, -1 }; // ensure path of leaf node to be 0
        // division
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        // post-order
        int pathLeft = 1 + left[1]; // node.left + right-subpath
        int pathRight = 1 + right[0]; // node.right + left-subpath
        maxZigZagLen = Math.max(maxZigZagLen, Math.max(pathLeft, pathRight));
        // return
        return new int[]{ pathLeft, pathRight };
    }
}
