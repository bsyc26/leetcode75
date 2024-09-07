import java.util.List;
import java.util.LinkedList;

/** Return true if two binary tree are leaf-similar
  * leaf-similar: have the same leaf value seq from left to right */
public class Solution { // leetcode 872
    // dfs-traverse + argument-values
    public boolean leafSimilar(TreeNode root1, TreeNode root2) { // T: O(M+N), S: O(M+N).
        // variables
        List<Integer> leafs1 = new LinkedList<>();
        List<Integer> leafs2 = new LinkedList<>();
        // dfs
        dfs(root1, leafs1);
        dfs(root2, leafs2);
        // return
        return leafs1.equals(leafs2);
    }
    private void dfs(TreeNode node, List<Integer> leafs) {
        // base case
        if (node == null)
            return;
        // pre-order
        if (node.left == null && node.right == null) {
            leafs.add(node.val);
            return;
        }
        // traverse
        dfs(node.left, leafs);
        dfs(node.right, leafs);
    }
}
