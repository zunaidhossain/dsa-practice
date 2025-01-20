class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, new int[] { 0 }, Integer.MAX_VALUE);
    }

    private TreeNode bstFromPreorder(int[] preorder, int[] index, int bound) {
        if (index[0] >= preorder.length || preorder[index[0]] > bound)
            return null;

        TreeNode root = new TreeNode(preorder[index[0]]);
        index[0]++;
        root.left = bstFromPreorder(preorder, index, root.val);
        root.right = bstFromPreorder(preorder, index, bound);
        return root;
    }

}