import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

/** Return the values of node see ordered from top to bot */
public class BinaryTreeRightSideView { // leetcode 199
    // bfs
    public List<Integer> rightSideView(TreeNode root) { // T: O(N), S: O(N).
        // edge case
        if (root == null)
            return new LinkedList<Integer>();
        // variables
        List<Integer> rightNodes = new LinkedList<>();
        // data structures
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // bfs
        while (!q.isEmpty()) {
            // count level
            int sz = q.size();
            // loop level
            for (int i = 0; i < sz; i++) {
                // poll
                TreeNode curNode = q.poll();
                // base case
                if (i == sz-1)
                    rightNodes.add(curNode.val);
                // offer
                if (curNode.left != null)
                    q.offer(curNode.left);
                if (curNode.right != null)
                    q.offer(curNode.right);
            }
        }
        // return
        return rightNodes;
    }
}
