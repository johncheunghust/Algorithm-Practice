import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintFromTopToBottom {
    static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        ArrayList<Integer> l = new ArrayList<>();
        if(root==null) return l;
        while(!q.isEmpty()) {
            int sz = q.size();
            for(int i=0;i<sz;++i) {
                TreeNode t = q.peek();
                l.add(t.val);
                if(t.left!=null) q.add(t.left);
                if(t.right!=null) q.add(t.right);
                q.poll();
            }
        }
        return l;
    }
}
