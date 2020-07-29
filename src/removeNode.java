import java.lang.annotation.Target;
import java.util.LinkedList;
import java.util.Queue;

public class removeNode {
    public static void main(String[] args) {
        TreeNode root = deserialize("1,#,2,#,3,#,4,#,5");
        removeNode(root,3);
    }

    static TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        TreeNode targetParent = findParentNode(dummy, root, value);
        if(targetParent==null) return root;
        TreeNode target = targetParent.left!=null&&targetParent.left.val==value? targetParent.left:targetParent.right;
        if(target.right==null) {
            if(targetParent.left==target) targetParent.left=target.left;
            else targetParent.right = target.left;
        }
        else {
            TreeNode node = target.right;
            TreeNode nodeTail = target;
            while(node.left!=null) {
                nodeTail=node;
                node=node.left;
            }
            if(nodeTail.right==node) {
                node.left = target.left;
            }
            else {
                nodeTail.left=node.right;
                node.left = target.left;
                node.right = target.right;
            }
            if(targetParent.left==target) targetParent.left=node;
            else targetParent.right = node;
        }
        return dummy.left;
    }

    static TreeNode findParentNode(TreeNode parent, TreeNode target, int value) {
        if(target==null) return null;
        if(target.val == value) return parent;
        else if(target.val<value) {
            if(parent.left==target) parent = parent.left;
            else parent= parent.right;
            return findParentNode(parent, target.right, value);
        }
        else {
            if(parent.left==target) parent = parent.left;
            else parent= parent.right;
            return findParentNode(parent, target.left, value);
        }
    }
    static TreeNode deserialize(String data) {
        // write your code here
        if(data.length()==0) return null;
        StringBuilder sb = new StringBuilder(data);
        sb.append(',');
        int cut = sb.indexOf(",");
        String rootVal = sb.substring(0,cut);
        sb.delete(0,cut+1);
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(rootVal));
        q.offer(root);
        while(sb.length()!=0) {
            int sz = q.size();
            for(int i=0;i<sz;++i) {
                TreeNode temp = q.poll();
                cut = sb.indexOf(",");
                String tmp = sb.substring(0,cut);
                sb.delete(0,cut+1);
                if(!tmp.equals("#")) {
                    temp.left = new TreeNode(Integer.parseInt(tmp));
                    q.offer(temp.left);
                }
                cut = sb.indexOf(",");
                tmp = sb.substring(0,cut);
                sb.delete(0,cut+1);
                if(!tmp.equals("#")) {
                    temp.right = new TreeNode(Integer.parseInt(tmp));
                    q.offer(temp.right);
                }
            }
        }
        return root;
    }
}
