/*
class Node {
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/

// class Solution {
//     public Node segregate(Node head) {
//         // code here
        
//     }
// }


class Solution {
    public Node segregate(Node head) {
        if (head == null || head.next == null) return head;

        Node zeroD = new Node(0), oneD = new Node(0), twoD = new Node(0);
        Node zero = zeroD, one = oneD, two = twoD;

        Node curr = head;
        while (curr != null) {
            if (curr.data == 0) {
                zero.next = curr;
                zero = zero.next;
            } else if (curr.data == 1) {
                one.next = curr;
                one = one.next;
            } else {
                two.next = curr;
                two = two.next;
            }
            curr = curr.next;
        }

        // Join three lists
        zero.next = (oneD.next != null) ? oneD.next : twoD.next;
        one.next = twoD.next;
        two.next = null;

        return zeroD.next;
    }
}
