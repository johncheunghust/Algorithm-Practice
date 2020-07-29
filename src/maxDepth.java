public class maxDepth {
    public int maxDepth(TreeNode root) {
        // write your code here
        if(root==null) return 0;
        return 1+Math.max(maxDepth(root.left) ,maxDepth(root.right));
    }
}