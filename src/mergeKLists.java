import java.util.*;

public class mergeKLists {
//    private Comparator<ListNode> LNComparator = new Comparator<ListNode>() {
//        @Override
//        public int compare(ListNode o1, ListNode o2) {
//            return o1.val-o2.val;
//        }
//    };
    public static void main(String[] args) {
        List<ListNode> lists = new ArrayList<>();
        ListNode l1 = new ListNode(-1);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(11);
        ListNode l4 = new ListNode(6);
        ListNode l5 = new ListNode(10);
        l1.next=l2;
        l2.next=l3;
        l4.next=l5;
        lists.add(null);
        lists.add(l1);
        lists.add(null);
        lists.add(l4);

        ListNode l = mergeKLists(lists);
        int i=1;
    }
    static ListNode mergeKLists(List<ListNode> lists) {
        // write your code here
//        ArrayList<Integer> r = new ArrayList<>();
//        r.add(null);
//        lists.removeAll(r);
//        if(lists.size()==0) return null;
//        Collections.sort(lists, new ListNodeComparator());
//        ListNode dummy = new ListNode(0);
//        ListNode d = dummy;
//        while(lists.size()!=0) {
//            ListNode cur = lists.get(0);
//            d.next = new ListNode(cur.val);
//            d=d.next;
//            if(cur.next==null) {
//                lists.remove(0);
//                continue;
//            }
//            else {
//                ListNode next = cur.next;
//                lists.remove(0);
//                int i=0;
//                if(lists.size()==0) {
//                    lists.add(i,next);
//                    continue;
//                }
//                while(i<lists.size()&&lists.get(i).val<next.val) ++i;
//                lists.add(i,next);
//            }
//        }
//        return dummy.next;
        if(lists.size()==0) return null;
        ListNode dummy = new ListNode(0);
        Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), new ListNodeComparator() );
        for(ListNode l: lists) {
            if(l==null) continue;
            heap.add(l);
        }
        ListNode l = dummy;
        while(heap.size()!=0) {
            l.next = heap.poll();
            l = l.next;
            if(l.next!=null) heap.add(l.next);
        }
        return dummy.next;
    }
}



class ListNodeComparator implements Comparator<ListNode> {
    @Override
    public int compare(ListNode a, ListNode b ) {
        if(a.val<b.val) return -1;
        if(a.val==b.val) return 0;
        else return 1;
    }
}
