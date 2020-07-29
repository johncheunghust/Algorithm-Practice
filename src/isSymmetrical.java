public class isSymmetrical {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        System.out.println(isSymmetrical(root));
    }
    static boolean isSymmetrical(TreeNode root)
    {
        TreeNode m = mirror(root);
        return isMirror(root, m);
    }
    static boolean isMirror(TreeNode root, TreeNode m) {
        if(root==null&&m==null) return true;
        if(root==null||m==null) return false;
        if(root.val==m.val) {
            return isMirror(root.left, m.left)&&isMirror(root.right, m.right);
        }
        else return false;
    }
    static TreeNode mirror(TreeNode root) {
        if(root==null) return null;
        TreeNode l = root.left;
        TreeNode r = root.right;
        l = mirror(root.left);
        r = mirror(root.right);
        root.left = r;
        root.right = l;
        return root;
    }
}
