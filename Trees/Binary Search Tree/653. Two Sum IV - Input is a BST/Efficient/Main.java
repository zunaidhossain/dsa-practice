class Solution {
    /*
     * Efficient Solution
     * Time Complexity: O(N) + O(NlogN)
     * Space Complexity: O(2^H) (H = Height of tree)
     */
    public boolean findTarget(TreeNode root, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            int target = k - curr.val;
            if(Find(root, target, curr)) {
                return true;
            }
            if(curr.left != null)
                q.offer(curr.left);
            if(curr.right != null)
                q.offer(curr.right);
        }
        return false;
    }
    private boolean Find(TreeNode root, int target, TreeNode original) {
        while(root != null) {
            if(root.val == target && root != original)
                return true;
            else if(root.val < target)
                root = root.right;
            else
                root = root.left;
        }
        return false;
    }
}