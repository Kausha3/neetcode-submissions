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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder result = new StringBuilder();

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                result.append("null,");
            }
            else {
                result.append(node.val + ",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") return null;
        String[] string = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(string[0]));

        queue.offer(root);

        for (int i = 1; i < string.length; i++) {
            TreeNode node = queue.poll();
            if(!string[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(string[i]));
                queue.offer(node.left);
            }
            if (!string[++i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(string[i]));
                queue.offer(node.right);
            }
        }
        return root;
        
    }
}
