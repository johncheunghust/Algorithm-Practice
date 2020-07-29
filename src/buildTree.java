import java.util.HashMap;

public class buildTree {
    public static void main(String[] args) {
        int[] p = {1,2};
        int[] i = {1,2};
        TreeNode t = buildTree(p, i);
        TreeNode tt = t;
    }
    static TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int i=0; i<inorder.length; ++i) m.put(inorder[i], i);
        if(preorder.length==0) return null;
        return helper(0, 0, inorder.length-1, preorder, inorder, m);
}
    static TreeNode helper(int prestart, int instart, int inend, int[] preorder, int[] inorder, HashMap<Integer, Integer> m) {
        if(prestart>preorder.length-1||inend-instart<0) return null;
        if(inend-instart==0) return new TreeNode(preorder[prestart]);
        int v = preorder[prestart];
        int index = m.get(v);
        TreeNode t = new TreeNode(v);
        t.left = helper(prestart+1, instart, index-1, preorder, inorder, m);
        t.right = helper(prestart+index-instart+1, index+1, inend, preorder, inorder, m);
        return t;
    }
}
