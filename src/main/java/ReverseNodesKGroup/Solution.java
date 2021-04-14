package ReverseNodesKGroup;


public class Solution {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode reverseKGroup(ListNode head, int k) {
      int numberNodes = 0;
      ListNode node = head;

      while(node != null) {
        numberNodes++;
        node = node.next;
      }

      if(numberNodes == k){
        ListNode reversedList = reverseBetween(head, node);
        head.next = reverseKGroup(node, k);
        return reversedList;
      }

      return head;
    }
    //Reverse list between start and end
  private ListNode reverseBetween(ListNode head, ListNode endNode) {
      ListNode s = new ListNode(0);
      s.next = head;

      ListNode prev = s;
      ListNode current = head;

      while(current != null && current.next != null
              && current.next != endNode) {
        ListNode tmp = current.next;
        current.next = current.next.next;
        tmp.next = prev.next;
        prev.next = tmp;
      }
      return s.next;
  }
}
