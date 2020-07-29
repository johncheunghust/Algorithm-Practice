import java.util.LinkedList;
import java.util.Queue;

public class deserialize {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(serialize(deserialize("989,982,#,972,#,947,#,920,#,903,#,894,#,881,#,866,#,864,#,842,#,841,#,796,#,726,#,647,#,613,719,593,#,#,#,590,#,558,#,554,#,538,#,512,#,504,#,468,505,467,#,#,#,456,#,413,#,331,#,330,407,320,#,#,#,312,#,306,#,301,#,274,#,251,#,235,#,231,#,222,#,181,#,93,#,83,#,73,#,64,#,62,#,60,#,28,#,21,#,20,#,-32,#,-52,#,-70,#,-87,#,-98,#,-102,#,-115,#,-116,#,-139,#,-183,#,-224,#,-241,#,-263,#,-284,#,-294,#,-296,#,-320,#,-330,#,-392,#,-398,#,-407,#,-431,#,-445,#,-460,#,-463,#,-492,#,-507,#,-518,#,-539,#,-552,#,-558,#,-559,#,-587,#,-673,#,-736,#,-757,#,-766,#,-767,#,-823,#,-830,#,-867,#,-875,#,-891,#,-905,#,-910,#,-924,#,-960,#,-985")));

    }
    static String serialize(TreeNode root) {
        // write your code here
        if(root==null) return "";
        int depth = getdepth(root);
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        int curDepth = 1;
        queue.offer(root);
        while(curDepth<depth) {
            int length = queue.size();
            for(int i=0;i<length; ++i) {
                TreeNode temp = queue.poll();
                if(temp==null) {
                    sb.append("#,");
                    continue;
                }
                sb.append(temp.val);
                sb.append(',');
                queue.offer(temp.left);
                queue.offer(temp.right);
            }
            curDepth++;
        }
        int sz = queue.size();
        for(int i=0;i<sz;++i) {
            TreeNode temp = queue.poll();
            if(temp==null) {
                sb.append("#,");
                continue;
            }
            sb.append(temp.val);
            sb.append(',');
        }
        int ed = sb.length();
        sb.delete(ed-1,ed);
        return  sb.toString();
    }
    static int getdepth(TreeNode root) {
        if(root==null) return 0;
        return 1+Math.max(getdepth(root.left), getdepth(root.right));
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
