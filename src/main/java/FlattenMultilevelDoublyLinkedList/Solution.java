package FlattenMultilevelDoublyLinkedList;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

public class Solution {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public Node flatten(Node head) {

        if(head == null) return head;

        Node pointer = head;
        while(pointer != null){
            if (pointer.child != null) {
                Node right = pointer.next;

                //process child
                pointer.next = flatten(pointer.child);
                pointer.next.prev = pointer;
                pointer.child = null;

                while (pointer.next != null)
                    pointer = pointer.next;

                //Reconnect next 
                if (right != null) {
                    pointer.next = right;
                    pointer.next.prev = pointer;
                }
            }
            pointer = pointer.next;
            

        }
        return head;
    }
}