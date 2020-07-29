import java.util.List;

public class reverse {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        reverse(head);
    }
    static ListNode reverse(ListNode head) {
        // write your code here
        ListNode prev = null;
        while(head!=null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}
