class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null) {
            if(p.val > root.val && q.val > root.val) { // p & q both on right
                root = root.right;
            } else if(p.val < root.val && q.val < root.val) { // p & q both on left
                root = root.left;
            } else {
                break;
            }
        }
        return root;
    }
}