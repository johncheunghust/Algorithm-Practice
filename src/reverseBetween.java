public class reverseBetween {
    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        reverseBetween(l, 2,3);
    }
    static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = head;
        if(m==1) {
            for(int i=0; i<n; ++i) {
                dummy = dummy.next;
            }
            ListNode newHead = reverseList(head, n-m, dummy);
            return newHead;
        }
        else {
            for(int i=0;i<m-2;++i) dummy = dummy.next;
            ListNode d = head;
            for(int i=0; i<n;++i) d = d.next;
            dummy.next = reverseList(dummy.next, n-m, d);
            return head;
        }

    }
    static ListNode reverseList(ListNode head, int len, ListNode nextt) {
        ListNode prev = nextt;
        int i=0;
        while(i<len+1&&head!=null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
            ++i;
        }
        return prev;
    }
}
