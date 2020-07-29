public class minDepth {
    public static void main(String[] args) {
        TreeNode r = new TreeNode(1);
        r.left = new TreeNode(2);
        System.out.println(minDepth(r));
    }
    static int minDepth(TreeNode root) {
        if(root==null) return 0;
        else if(root.left==null&&root.right==null) return 1;
        else if(root.left==null||root.right==null) {
            if(root.left!=null) return minDepth(root.left)+1;
            else return minDepth(root.right)+1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) +1;
    }
}
