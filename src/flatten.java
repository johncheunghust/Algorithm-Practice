import java.util.*;

public class flatten {
    Queue<TreeNode> pq = new LinkedList<>();
    public void flatten(TreeNode root) {
        traverse(root);
        TreeNode head = pq.poll();
        TreeNode dummy = head;
        while(!pq.isEmpty()) {
            dummy.left=null;
            dummy.right = pq.poll();
            dummy=dummy.right;
        }
    }
    void traverse(TreeNode root) {
        if(root!=null) pq.add(root);
        else return;
        traverse(root.left);
        traverse(root.right);
    }
}
