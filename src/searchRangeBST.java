import java.util.ArrayList;
import java.util.List;

public class searchRangeBST {
    static List<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        int[] ret = myInOrderTraverse(root,k1,k2);
        List result = new ArrayList();
        for(int i: ret) result.add(i);
        return result;
    }
    static int[] myInOrderTraverse(TreeNode root, int k1, int k2) {
        if(root==null) return new int[0];
        if(root.val<k1) return myInOrderTraverse(root.right,k1,k2);
        if(root.val>k2) return myInOrderTraverse(root.left,k1,k2);
        int[] r1 = myInOrderTraverse(root.left,k1, k2);
        int[] r2 = {root.val};
        int[] r3 = myInOrderTraverse(root.right,k1,k2);
        int[] ret = new int[r1.length+1+r3.length];
        for(int i=0;i<r1.length;++i) ret[i] = r1[i];
        ret[r1.length] = r2[0];
        for(int i=0;i<r3.length;++i) ret[r1.length+1+i] = r3[i];
        return ret;
    }
}
