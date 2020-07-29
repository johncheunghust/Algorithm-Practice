public class sortList {
    public ListNode sortList(ListNode head) {
        // write your code here
        if(head==null||head.next==null) return head;
        int count = 1;
        ListNode dummy = head;
        while(dummy.next!=null) {
            count++;
            dummy=dummy.next;
        }
        return mergeSort(head, count);
    }
    static ListNode mergeSort(ListNode head, int count) {
        if(count==1||count==0) return head;
        int mid = count/2;
        ListNode lastDummy = head;
        for(int i=0;i<mid-1; ++i) lastDummy = lastDummy.next;
        ListNode temp = lastDummy.next;
        lastDummy.next = null;
        lastDummy = temp;
        ListNode firstDummy = head;
        firstDummy = mergeSort(firstDummy, count/2);
        int lastCount = count%2==1?(count/2)+1:count/2;
        lastDummy = mergeSort(lastDummy, lastCount);
//        merge
        ListNode dummy = new ListNode(0);
        ListNode l  = dummy;
        while(firstDummy!=null&&lastDummy!=null) {
            if(firstDummy.val>lastDummy.val) {
                l.next = lastDummy;
                lastDummy = lastDummy.next;
            }
            else {
                l.next = firstDummy;
                firstDummy = firstDummy.next;
            }
            l = l.next;
        }
        if(firstDummy!=null) l.next = firstDummy;
        else l.next = lastDummy;
        return dummy.next;
    }
}
