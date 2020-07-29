public class partitionList {
    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(4);
        l.next.next = new ListNode(3);
        partition(l, 3);
    }
    static ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(1);
        ListNode dummy = head;
        ListNode t1 = dummy1;
        ListNode t2 = dummy2;
        ListNode lastDummy = dummy;
        while(dummy!=null) {
            if(dummy.val<x) {
                t1.next = dummy;
                t1 = t1.next;
            }
            else {
                t2.next = dummy;
                t2 = t2.next;
            }
            lastDummy = dummy;
            dummy = dummy.next;
            lastDummy.next = null;
        }
        t1.next = dummy2.next;
        return dummy1.next;
    }
}
