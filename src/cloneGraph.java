import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


public class cloneGraph {
    public static void main(String[] args) {
    }
    Map<Integer, Node> m = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        if(m.containsKey(node.val)) return m.get(node.val);
        List<Node> n = node.neighbors;
        ArrayList<Node> nn = new ArrayList<>();
        for(Node t: n) {
            Node newNode = cloneGraph(t);
            nn.add(newNode);

        }
        Node ret = new Node(node.val, nn);
        m.put(ret.val, ret);
        return ret;
    }
}
