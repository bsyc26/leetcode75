import java.util.Queue;
import java.util.LinkedList;

/** Return the min level (root is level 1) with all nodes in this level sum to max val */
public class MaximumLevelSumOfABinaryTree { // leetcode 1161
    // bfs
    public int maxLevelSum(TreeNode root) { // T: O(N), S: O(N)
        // data structures
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // variables
        int maxSum = Integer.MIN_VALUE; // node.val can be negative
        int levelSumMax = 1;
        int curLevel = 1;
        // bfs
        while (!q.isEmpty()) {
            // count level
            int sz = q.size();
            int curSum = 0;
            // loop level
            for (int i = 0; i < sz; i++) {
                // poll
                TreeNode curNode = q.poll();
                // manage state
                curSum += curNode.val;
                // offer
                if (curNode.left != null)
                    q.offer(curNode.left);
                if (curNode.right != null)
                    q.offer(curNode.right);
            }
            // post level
            if (curSum > maxSum) {
                maxSum = curSum; 
                levelSumMax = curLevel;
            }
            ++curLevel;
        }
        // return
        return levelSumMax;
    }
}
