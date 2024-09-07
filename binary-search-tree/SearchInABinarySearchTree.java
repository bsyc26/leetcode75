/** REturn the subtree rooted node with the target val, or null */
public class Solution { // leetcode 700
    // bst
    public TreeNode searchBST(TreeNode root, int val) { // T: O(logN), S: O(1).
        // edge case
        if (root == null)
            return null;
        // return
        return bst(root, val);
    }
    private TreeNode bst(TreeNode node, int tgt) {
        // base case
        if (node == null)
            return null;
        // left search
        if (node.val > tgt)
            return bst(node.left, tgt);
        // right search
        if (node.val < tgt)
            return bst(node.right, tgt);
        // found target
        return node;
    }
}
