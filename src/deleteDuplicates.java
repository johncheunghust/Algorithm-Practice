public class deleteDuplicates {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(0);
        ListNode head = a1;
        a1.next = new ListNode(1);
        a1 = a1.next;
        a1.next = new ListNode(3);
        a1 = a1.next;
        a1.next = new ListNode(3);
        deleteDuplicates(head);
    }
    static ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if(head == null) return null;
        ListNode l = head;
        while(l.next!=null) {
            if(l.val!=l.next.val) l=l.next;
            else {
                l.next = l.next.next;
            }
        }
        return head;
    }
}
