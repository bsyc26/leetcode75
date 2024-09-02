/** Delete the node with key val and return the root node (possible update) */
public class DeleteNodeInABST { // leetcode 450
    // bst
    public TreeNode deleteNode(TreeNode root, int key) { // T: O(logN), S: O(1).
        // edge case
        if (root == null)
            return null;
        // return
        return bst(root, key);
    }
    private TreeNode bst(TreeNode node, int tgt) {
        // base case
        if (node == null)
            return null;
        // binary search
        if (node.val > tgt)
            node.left = bst(node.left, tgt);
        else if (node.val < tgt)
            node.right = bst(node.right, tgt);
        else { // found target
            // one child
            if (node.right == null) 
                return node.left;
            if (node.left == null)
                return node.right;
            // two child
            TreeNode min = getMin(node.right); // min node whose val > node.val
            node.right = bst(node.right, min.val); // del min node
            min.left = node.left;
            min.right = node.right;
            node = min; // place min in the del node former loc
        }
        // return 
        return node;
    }
    private TreeNode getMin(TreeNode node) { // find the leftmost child of node
        while (node.left != null)
            node = node.left;
        return node;
    }
}
