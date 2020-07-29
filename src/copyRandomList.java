import java.util.HashMap;
import java.util.Map;

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
};

public class copyRandomList {
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if(head==null) return null;
        RandomListNode ret = new RandomListNode(0);
        Map<RandomListNode, RandomListNode> m = new HashMap<>();
        RandomListNode dummy = head, rln = ret;
        while(dummy!=null) {
            RandomListNode newNode;
            if(m.containsKey(dummy)) {
                newNode = m.get(dummy);
            }
            else {
                newNode = new RandomListNode(dummy.label);
                m.put(dummy, newNode);
            }
            rln.next = newNode;
            if(dummy.random==null) rln.next.random=null;
            else if(m.containsKey(dummy.random)) {
                newNode.random = m.get(dummy.random);
            }
            else {
                newNode.random = new RandomListNode(dummy.random.label);
                m.put(dummy.random, newNode.random);
            }
            rln = newNode;
            dummy = dummy.next;
        }
        return ret.next;
    }
}
