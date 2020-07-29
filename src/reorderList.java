public class reorderList {
    public static void main(String[] args) {
        ListNode a = new ListNode(0);
        a.next = new ListNode(3);
        a.next.next = new ListNode(1);
        a.next.next.next = new ListNode(-1) ;
        reorderList(a);
    }
    static void reorderList(ListNode head) {
        // write your code here
        if(head==null||head.next==null) return;
        int count = 0;
        ListNode backDummy = head;
        while(backDummy!=null) {
            ++count;
            backDummy = backDummy.next;
        }
        ListNode firstDummy = head, lastDummy = head;
        int mid = count%2==1?count/2+1:count/2;
        for(int i=0;i<mid-1;++i) lastDummy = lastDummy.next;
        backDummy = lastDummy;
        lastDummy = lastDummy.next;
        backDummy.next = null;
        ListNode prev = null;
        while(lastDummy!=null) {
            ListNode next = lastDummy.next;
            lastDummy.next = prev;
            prev = lastDummy;
            lastDummy = next;
        }
        lastDummy = prev;
        while(firstDummy!=null&&lastDummy!=null) {
            ListNode firstNext = firstDummy.next;
            ListNode lastNext = lastDummy.next;
            firstDummy.next = lastDummy;
            lastDummy.next = firstNext;
            firstDummy = firstNext;
            lastDummy = lastNext;
        }
    }
}
