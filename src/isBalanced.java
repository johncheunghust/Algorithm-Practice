public class isBalanced {
    public boolean isBalanced(TreeNode root) {
        // write your code here
        return getDepth(root)!=-1;
    }
    static int getDepth(TreeNode root) {
        if(root==null) return 0;
        int ld = getDepth(root.left);
        int rd = getDepth(root.right);
        if(ld==-1||rd==-1||Math.abs(ld-rd)>1) return -1;
        return Math.max(ld, rd) +1;
    }
}
