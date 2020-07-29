public class insertNode {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        insertNode(null, node);
    }
    static TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if(root==null) return node;
        TreeNode dummy = root;
        while(dummy!=null) {
            if(dummy.val<node.val) {
                if(dummy.right==null) {
                    dummy.right = node;
                    return root;
                }
                else dummy = dummy.right;
            }
            else if(dummy.val>node.val) {
                if(dummy.left==null) {
                    dummy.left = node;
                    return root;
                }
                else dummy = dummy.left;
            }
            else return root;
        }
        dummy = new TreeNode(node.val);
        return root;
    }
}
