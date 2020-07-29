import java.util.HashMap;

public class LRUCache {
    public static void main(String[] args) {
        LRUCache1 cache = new LRUCache1(2);
        cache.put(2,1);
        cache.put(1,1);
        cache.put(2,3);
        cache.put(4,1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
;
    }
}

class LRUCache1 {
    int cap;
    HashMap<Integer, ListNode1> m;
    HashMap<ListNode1, Integer> rm;
    ListNode1 head;
    ListNode1 tail;
    int size;
    public LRUCache1(int capacity) {
        cap = capacity;
        m = new HashMap<>();
        rm = new HashMap<>();
        head = null;
        tail = null;
        size = 0;
    }

    public int get(int key) {
        if(!m.containsKey(key)) return -1;
        ListNode1 chosen = m.get(key);
        if(chosen.prev==null) return chosen.val;
        ListNode1 prev = chosen.prev;
        ListNode1 next = chosen.next;
        if(chosen.next ==null) tail = prev;
        chosen.next = head;
        head.prev = chosen;
        chosen.prev = null;
        head = chosen;
        prev.next = next;
        if(next!=null) next.prev = prev;
        return chosen.val;
    }

    public void put(int key, int value) {
        ListNode1 newNode = new ListNode1(value);
        if(m.containsKey(key)) {
            ListNode1 temp = m.get(key);
            if(temp.prev==null) head = temp.next;
            if(temp.next==null) tail = temp.prev;
            rm.remove(temp);
            ListNode1 prev = temp.prev;
            ListNode1 next = temp.next;
            if(prev!=null) prev.next = next;
            if(next!=null) next.prev = prev;
        }
        else if (++size > cap) {
            int t = rm.get(tail);
            m.remove(t);
            rm.remove(tail);
            ListNode1 prev = tail.prev;
            if(prev!=null) prev.next = null;
            tail = prev;
            --size;
        }

        m.put(key, newNode);
        rm.put(newNode, key);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
    }
}

class ListNode1 {
    int val;
    ListNode1 next;
    ListNode1 prev;
    public ListNode1(int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}