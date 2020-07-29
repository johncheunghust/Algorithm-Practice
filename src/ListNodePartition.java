public class ListNodePartition {
    public static void main(String[] args) {
        ListNode a = new ListNode(3);
        a.next = new ListNode(3);
        a.next.next = new ListNode(1);
        a.next.next.next = new ListNode(2);
        a.next.next.next.next = new ListNode(4);
        partition(a,3);
    }
    static ListNode partition(ListNode head, int x) {
        // write your code here
        ListNode ret = new ListNode(0);
        ListNode dummy = ret;
        ListNode dum = head;
        while(dum!=null) {
            if(dum.val<x) {
                dummy.next = new ListNode(dum.val);
                dummy = dummy.next;
            }
            dum = dum.next;
        }
        dum = head;
        while(dum!=null) {
            if(dum.val>=x) {
                dummy.next = new ListNode(dum.val);
                dummy = dummy.next;
            }
            dum = dum.next;
        }
        return ret.next;
    }
}
