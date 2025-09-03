/*
class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
// */
// class Solution {
//     public Node reverse(Node head) {
//         // code here
        
//     }
// }

class Solution {
    public Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head; // empty list or single node
        }

        Node current = head;
        Node temp = null;

        while (current != null) {
            // swap prev and next
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;

            // move to next node (which is actually previous due to swap)
            current = current.prev;
        }

        // temp is now at the node before null, i.e., the new head
        if (temp != null) {
            head = temp.prev;
        }

        return head;
    }
}
