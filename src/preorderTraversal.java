import java.util.ArrayList;
import java.util.List;

public class preorderTraversal {
    static List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> ret = new ArrayList();
        if(root==null) return ret;
        ret.add(root.val);
        List l = preorderTraversal(root.left);
        for(Object i: l) ret.add(Integer.parseInt(i.toString()));
        List r = preorderTraversal(root.right);
        for(Object i: r) ret.add(Integer.parseInt(i.toString()));
        return ret;
    }

}
