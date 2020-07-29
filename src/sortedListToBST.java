class TreeNode {
      public int val;
      public TreeNode left, right;
      public TreeNode(int val) {
          this.val = val;
          this.left = this.right = null;
 }
}

public class sortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        return helper(head, null);
    }
    static TreeNode helper(ListNode head, ListNode tail) {
        if(head==tail) return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=tail&&fast.next!=tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = helper(head, slow);
        root.right = helper(slow.next, tail);
        return root;
    }
}
