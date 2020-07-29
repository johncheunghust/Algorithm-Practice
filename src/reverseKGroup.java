public class reverseKGroup {
    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
//        l.next.next = new ListNode(3);
//        l.next.next.next = new ListNode(4);
//        l.next.next.next.next = new ListNode(5);
        reverseKGroup(l, 2);
    }
    static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        if(k==1||head==null||head.next==null) return head;
        ListNode l = dummy;
        l.next = head;
        ListNode cur=l.next;
        for(int i=0;i<k-1;++i) {
            if(cur==null) {
                return head;
            }
            cur=cur.next;
        }
        while(cur!=null) {
            ListNode nextl = l.next;
            ListNode rev = nextl.next;
            nextl.next = cur.next;
            ListNode prev = nextl;
            ListNode nextRev = rev.next;
            for(int i=0;i<k-1;i++) {
                nextRev = rev.next;
                rev.next = prev;
                prev=rev;
                rev = nextRev;
            }
            l.next = prev;
            l = nextl;
            cur = rev;
            for(int i=0;i<k-1;++i) {
                if(cur==null) {
                    break;
                }
                cur=cur.next;
            }

        }
        return dummy.next;
    }
}
