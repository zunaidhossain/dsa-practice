class Solution {
    /*
     * Optimal Approach
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public void recoverTree(TreeNode root) {
        TreeNode[] first = new TreeNode[1];
        TreeNode[] mid = new TreeNode[1];
        TreeNode[] last = new TreeNode[1];
        inorderTraversal(root, new TreeNode[1], first, mid, last);
        if(last[0] == null) {
            swap(first[0], mid[0]);
        } else {
            swap(first[0], last[0]);
        }
    }
    private void inorderTraversal(TreeNode root, TreeNode[] prev, TreeNode[] first,
                                  TreeNode[] mid, TreeNode[] last) {
        if(root == null)
            return;
        inorderTraversal(root.left, prev, first, mid, last);
        if(last[0] != null)
            return;
        if(prev[0] != null) {
            if(prev[0].val > root.val) {
                if(first[0] == null) {
                    first[0] = prev[0];
                    mid[0] = root;
                } else {
                    last[0] = root;
                }
            }
        }
        prev[0] = root;
        inorderTraversal(root.right, prev, first, mid, last);
    }
    private void swap(TreeNode node1, TreeNode node2) {
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }
}