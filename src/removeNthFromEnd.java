
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
}



public class removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        ListNode a = head,b = head;
        for(int i=0; i<n; ++i) b=b.next;
        if(b==null) return head.next;
        b=b.next;
        while(b!=null) {
            a=a.next;
            b=b.next;
        }
        a.next=a.next.next;
        return head;
    }
}
