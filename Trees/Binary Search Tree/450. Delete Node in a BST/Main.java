class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return root;
        if(root.val == key)
            return helper(root);
        TreeNode curr = root;
        while(curr != null) {
            if(key > curr.val) { // go right
                if(curr.right != null && curr.right.val == key) {
                    curr.right = helper(curr.right);
                    break;
                } else {
                    curr = curr.right;
                }
            } else { // go left
                if(curr.left != null && curr.left.val == key) {
                    curr.left = helper(curr.left);
                    break;
                } else {
                    curr = curr.left;
                }
            }
        }
        return root;
    }
    private TreeNode helper(TreeNode root) {
        if(root.left == null) {
            return root.right;
        } else if(root.right == null) {
            return root.left;
        } else {
            TreeNode rightChild = root.right;
            TreeNode lastRight = lastRightNode(root.left);
            lastRight.right = rightChild;
            return root.left;
        }
    }
    private TreeNode lastRightNode(TreeNode root) {
        if(root.right == null) {
            return root;
        }
        return lastRightNode(root.right);
    }
}