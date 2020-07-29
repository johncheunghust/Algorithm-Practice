import java.util.ArrayList;
import java.util.Stack;

public class zhiPrint {
    public static void main(String[] args) {
        
    }
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(pRoot);
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        if(pRoot==null) return ret;
        while(!s1.isEmpty()) {
            ArrayList<Integer> a = new ArrayList<>();
            int sz = s1.size();
            for(int i=0; i<sz; ++i) {
                TreeNode t = s1.pop();
                if(t.right!=null) s2.push(t.right);
                if(t.left!=null) s2.push(t.left);
                a.add(t.val);
            }
            ret.add(a);
            sz = s2.size();
            ArrayList<Integer> b = new ArrayList<>();
            if(sz==0) break;
            for(int i=0; i<sz; ++i) {
                TreeNode t = s1.pop();
                if(t.left!=null) s1.push(t.left);
                if(t.right!=null) s1.push(t.right);
                b.add(t.val);
            }
            ret.add(b);
        }
        return  ret;
    }
}
