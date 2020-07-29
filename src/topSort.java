import java.util.*;

public class topSort {
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> ret = new ArrayList<>();
        int[] inDegree = new int[graph.size()];
        for(DirectedGraphNode n: graph) {
            for(DirectedGraphNode nn:n.neighbors) ++inDegree[nn.label];
        }
        int count=0;
        Deque<DirectedGraphNode> dq = new ArrayDeque<>();
        for(int i=0;i<graph.size();++i) {
            if(inDegree[i]==0) dq.offer(graph.get(i));
        }
        while(!dq.isEmpty()) {
            DirectedGraphNode n = dq.poll();
            ret.add(n);
            for(DirectedGraphNode nn: n.neighbors) {
                inDegree[nn.label]--;
                if(inDegree[nn.label]==0) dq.offer(nn);
            }
        }
        return ret;
    }
}
 class DirectedGraphNode {
     int label;
     ArrayList<DirectedGraphNode> neighbors;
     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 };