

public class ConvertBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.right = new TreeNode(12);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        solution s = new solution();
        TreeNode t = s.Convert(root);
        TreeNode a = null;
    }

}

class solution {
    TreeNode prev = null;
    public TreeNode Convert(TreeNode root) {
        if(root==null) return null;
        Convert(root.right);
        if(prev == null) {
            prev = root;
        }
        else {
            prev.left = root;
            root.right = prev;
            prev = root;
        }
        Convert(root.left);
        return prev;
    }

}