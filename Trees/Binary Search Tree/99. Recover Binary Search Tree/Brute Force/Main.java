class Solution {
    /*
     * Brute Force Approach
     * Time Complexity: O(N) + O(NlogN) + O(N)
     * Space Complexity: O(N)
     */
    private void inorderTraversal(TreeNode root, List<Integer> nodes) {
        if(root == null)
            return;
        inorderTraversal(root.left, nodes);
        nodes.add(root.val);
        inorderTraversal(root.right, nodes);
    }
    public void recoverTree(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        inorderTraversal(root, nodes);
        Collections.sort(nodes);
        TreeNode[] target = new TreeNode[2];
        rectifyBST(root, nodes, new int[1], target);
        int temp = target[0].val;
        target[0].val = target[1].val;
        target[1].val = temp;
    }
    private void rectifyBST(TreeNode root, List<Integer> nodes, int[] index,
                            TreeNode[] target) {
        if(root == null)
            return;
        rectifyBST(root.left, nodes, index, target);
        if(target[1] != null) return;
        if(nodes.get(index[0]) != root.val) {
            if(target[0] == null) {
                target[0] = root;
            } else {
                target[1] = root;
                return;
            }
        }
        index[0]++;
        rectifyBST(root.right, nodes, index, target);
    }
}