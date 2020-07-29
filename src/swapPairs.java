import java.util.ArrayList;
import java.util.List;

public class swapPairs {
    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        swapPairs(l);
    }
    static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode l = dummy;
        l.next = head;
        while(l.next!=null&&l.next.next!=null) {
            ListNode first = l.next;
            ListNode sec = l.next.next;
            first.next = sec.next;
            l.next = sec;
            sec.next = first;
            l = l.next.next;
        }
        return dummy.next;
    }
}
