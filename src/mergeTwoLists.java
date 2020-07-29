//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x) {
//        val = x;
//        next = null;
//    }
//}
public class mergeTwoLists {
    /**
     * @param l1: ListNode l1 is the head of the linked list
     * @param l2: ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode dummy = new ListNode(0);
        ListNode l = dummy;
        while(l1!=null&&l2!=null) {
            if(l1.val >l2.val) {
                l.next = l2;
                l2 = l2.next;
            }
            else {
                l.next = l1;
                l1 = l1.next;
            }
            l = l.next;
        }
        if(l1!=null) l.next = l1;
        else l.next = l2;
        return dummy.next;
    }
}
