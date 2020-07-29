public class rotateRight {
    public static void main(String[] args) {
        ListNode a= new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(2);
        a.next.next.next.next = new ListNode(1);
        rotateRight(a,1);
    }
    static ListNode rotateRight(ListNode head, int k) {
        // write your code here
        if(head==null) return null;
        if(k==0) return head;
        ListNode dummy = head;
        int count = 1;
        while(dummy.next!=null) {
            ++count;
            dummy = dummy.next;
        }
        int kk = k%count;
        if(kk==0) return head;
        ListNode l = head;
        for(int i=0;i<count-kk-1;++i) l = l.next;
        ListNode ll = l.next;
        l.next = null;
        dummy.next = head;
        return ll;
    }
}
