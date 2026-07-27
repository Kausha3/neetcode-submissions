/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
	    if (root.val == p.val || root.val == q.val) return root;
	    TreeNode node = lowestCommonAncestor(root.left, p, q); 
        TreeNode node2 = lowestCommonAncestor(root.right, p, q);
        if (node == null) return node2;
        if (node2 == null) return node;
        if(node != null && node2 != null) return root;
        return null;
    }
}