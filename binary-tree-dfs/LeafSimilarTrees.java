import java.util.List;
import java.util.LinkedList;

/** Return true if two binary tree are leaf-similar
  * leaf-similar: have the same leaf value seq from left to right */
public class LeafSimilarTrees { // leetcode 872
    // dfs-traverse + argument-values
    public boolean leafSimilar(TreeNode root1, TreeNode root2) { // T: O(M+N), S: O(M+N).
        // variables
        List<Integer> leaves1 = new LinkedList<>();
        List<Integer> leaves2 = new LinkedList<>();
        // dfs
        dfs(root1, leaves1);
        dfs(root2, leaves2);
        // return
        return leaves1.equals(leaves2);
    }
    private void dfs(TreeNode node, List<Integer> leaves) {
        // base case
        if (node == null)
            return;
        // pre-order
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
            return;
        }
        // traverse
        dfs(node.left, leaves);
        dfs(node.right, leaves);
    }
}
