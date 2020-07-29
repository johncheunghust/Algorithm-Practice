import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrder {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        System.out.println(q.offer(1));
        System.out.println(q.offer(2));
        System.out.println(q.poll());
        q.element();

    }
    static List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here
        List result = new ArrayList();
        if(root==null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            List level = new ArrayList();
            int sz = q.size();
            for(int i=0;i<sz;++i) {
                TreeNode t = q.poll();
                if(t.left!=null) q.offer(t.left);
                if(t.right!=null) q.offer(t.right);
                level.add(t.val);
            }
            result.add(level);
        }
        return result;
    }
}
