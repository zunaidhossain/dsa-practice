class Solution {
    /*
     * Brute Force
     * Time Complexity: O(N) + O(N x N)
     * Space Complexity: O(N)
     */
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);
        int i = 0;
        int j = inorder.size() - 1;
        while(i < j) {
            int sum = inorder.get(i) + inorder.get(j);
            if(sum == k)
                return true;
            else if(sum > k)
                j--;
            else if(sum < k)
                i++;
        }
        return false;
    }
    private void inorderTraversal(TreeNode root, List<Integer> inorder) {
        if(root == null)
            return;
        inorderTraversal(root.left, inorder);
        inorder.add(root.val);
        inorderTraversal(root.right, inorder);
    }
}