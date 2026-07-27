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
    public boolean isValidBST(TreeNode root) {
        long minValue = Long.MIN_VALUE;
        long maxValue = Long.MAX_VALUE;
        return checkBT(root, minValue, maxValue);
    }

    private boolean checkBT(TreeNode root, long minValue, long maxValue) {
        if (root == null) return true;
        if ((long) root.val >= maxValue || (long) root.val <= minValue) {
            return false;
        }
        return checkBT(root.left, minValue, root.val) &&
        checkBT(root.right, root.val, maxValue);
    }
}
