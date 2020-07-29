public class isValidBST {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(-1);
        isValidBST(t);
    }


    static boolean isValidBST(TreeNode root) {
        return divcon(root).isBST;
    }
    static  ResultType divcon(TreeNode root) {
        if(root==null) return new ResultType(true);
        ResultType lr = divcon(root.left);
        ResultType rr = divcon(root.right);
        if(!lr.isBST||!rr.isBST) return new ResultType(false);
        if(lr.maxNode!=null&&lr.maxNode.val>=root.val) return new ResultType(false);
        if(rr.minNode!=null&&rr.minNode.val<=root.val) return new ResultType(false);
        ResultType ret = new ResultType(true);
        ret.minNode = lr.minNode==null?root:lr.minNode;
        ret.maxNode = rr.maxNode==null?root:rr.minNode;
        return ret;
    }
    static boolean dc(TreeNode root, long min, long max) {
        if(root==null) return true;
        if(root.val<=min||root.val>=max) return false;
        return dc(root.left, min, root.val) &&dc(root.right, root.val, max);
    }
}
class ResultType {
    public boolean isBST;
    public TreeNode maxNode, minNode;
    public ResultType(boolean isBST) {
        this.isBST = isBST;
        maxNode = null;
        minNode = null;
    }
}