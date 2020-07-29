public class deleteDuplicatesII {
    ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode dummy = dummyHead;
        while(dummy.next!=null) {
            int curV = dummy.next.val;
            ListNode t = dummy.next.next;
            if(t==null||t.val!=curV) dummy = dummy.next;
            else while(t!=null&&t.val==curV) {
                t=t.next;
            }
            dummy.next = t;

        }
        return dummyHead.next;
    }
}
