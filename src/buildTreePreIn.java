import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class buildTreePreIn {

    public static void main(String[] args) {
        int[] p = {3,9,20,15,7};
        int[] i = {9,3,15,20,7};
        TreeNode t = buildTree(p, i);
        TreeNode tt = t;
    }
    static TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = inorder.length;
        if(len==0) return null;
        int root = preorder[0];
        int leftNum = 0;
        for(;leftNum<len; ++leftNum) if(inorder[leftNum]==root) break;
        TreeNode t = new TreeNode(root);
        if(leftNum==0) t.left=null;
        else {
            int[] np = new int[leftNum];
            int[] ni = new int[leftNum];
            for(int i=0; i<leftNum; ++i) np[i] = preorder[i+1];
            for(int i=0; i<leftNum; ++i) ni[i] = inorder[i];
            t.left = buildTree(np, ni);
        }
        if(len-leftNum-1==0) t.right=null;
        else {
            int[] np1 = new int[len-leftNum-1];
            int[] ni1 = new int[len-leftNum-1];
            for(int i=0; i<len-leftNum-1; ++i) np1[i] = preorder[leftNum+1+i];
            for(int i=0; i<len-leftNum-1; ++i) ni1[i] = inorder[leftNum+1+i];
            t.right = buildTree(np1, ni1);
        }

        return t;
    }
}
