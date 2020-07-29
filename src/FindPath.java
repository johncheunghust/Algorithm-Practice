import javax.swing.tree.TreeCellRenderer;
import java.util.*;

public class FindPath {
    public static void main(String[] args) {
    }
    static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {


        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        dfs(root, target, ret, tmp);
        return ret;
    }

    static void dfs(TreeNode root, int target, ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> tmp) {
        if(root==null) return;
        if(root.val==target&&root.left==null&&root.right==null) {
            tmp.add(root.val);
            ret.add(new ArrayList<>(tmp));
            tmp.remove(tmp.size()-1);
            return;
        }
        else if(root.val>target) return;
        else {
            tmp.add(root.val);
            dfs(root.left, target-root.val, ret, tmp);
            dfs(root.right, target-root.val, ret, tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}
