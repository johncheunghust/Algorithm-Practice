import com.sun.source.tree.Tree;

import java.util.HashSet;
import java.util.Set;

public class longestConsecutive {
    public static void main(String[] args) {
        int[] n  = {100, 4, 200, 1, 3, 2};
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);
        root.right.right.right.right = new TreeNode(6);
        System.out.println(longestConsecutive(root));
    }
    static int longestConsecutive(int[] num) {
        // write your code here
        Set<Integer> s = new HashSet<>();
        for(int i:num) s.add(i);
        int longNum=0;
        for(int i:s) {
            int cur=0;
            if(s.contains(i-1)) continue;
            while (s.contains(i++)) {
                cur++;
            }
            longNum = Math.max(longNum, cur);
        }
        return longNum;
    }
    int longest = 0;
    static int longestConsecutive(TreeNode root) {
        return helper(root, null, 0);
    }
    static int helper(TreeNode root, TreeNode par, int lengthWithoutRoot) {
        if(root==null) return 0;
        int length = par!=null&&par.val+1==root.val?lengthWithoutRoot+1:1;
        int a = helper(root.left, root, length);
        int b = helper(root.right, root, length);
        return Math.max(length, Math.max(a,b));
    }

}
