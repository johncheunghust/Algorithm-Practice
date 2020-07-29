import java.util.HashMap;
import java.util.Map;

public class hasCycle {
    public boolean hasCycle(ListNode head) {
        // write your code here
        ListNode dummy = head;
        Map<ListNode, Integer> m = new HashMap<>();
        while(dummy!=null) {
            if(m.containsKey(dummy)) return true;
            else {
                m.put(dummy, 1);
                dummy = dummy.next;
            }
        }
        return false;
    }
}
