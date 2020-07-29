import com.sun.source.tree.Tree;

import java.util.HashMap;

public class buildTreeInPost {
    public static void main(String[] args) {
        int[] i={9,3,15,20,7};
        int[] p = {9,15,7,20,3};
        TreeNode t = buildTree(i,p);
        TreeNode tt = t;

    }
    static TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0) return null;
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int i=0; i<inorder.length; ++i) m.put(inorder[i], i);
        return helper(0, postorder.length-1, 0, inorder.length-1, inorder, postorder, m);
    }
    static TreeNode helper(int poststart, int postend, int instart, int inend, int[] inorder, int[] postorder, HashMap<Integer, Integer> m) {
        if(poststart>postend||instart>inend) return null;
        int v = postorder[postend];
        int index = m.get(v);
        TreeNode t = new TreeNode(v);
        t.left = helper(poststart, poststart+index-instart-1, instart, index-1, inorder, postorder, m);
        t.right = helper(poststart+index-instart, postend-1, index+1, inend, inorder, postorder,m);
        return t;
    }
}
