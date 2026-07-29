/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
		return recurse(root, targetSum, 0);
    }

    boolean recurse(TreeNode node, int targetSum, int costSoFar) {
		if (node == null) return false;
		if (node.left == null && node.right == null) {
			if (targetSum == costSoFar + node.val) return true;
		}

		boolean left = recurse(node.left, targetSum, costSoFar + node.val);
		boolean right = recurse(node.right, targetSum, costSoFar + node.val);
		
		return left || right;
	}

}