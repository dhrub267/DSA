// /*
// class Node {
//     int data;
//     Node next;

//     Node(int d) {
//         data = d;
//         next = null;
//     }
// }
// */

// class Solution {
//     public Node addTwoLists(Node head1, Node head2) {
//         // code here
        
//     }
// }


class Solution {

    Node reverse(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public Node addTwoLists(Node head1, Node head2) {

        head1 = reverse(head1);
        head2 = reverse(head2);

        int carry = 0;
        Node dummy = new Node(0);
        Node temp = dummy;

        while (head1 != null || head2 != null || carry != 0) {
            int sum = carry;

            if (head1 != null) {
                sum += head1.data;
                head1 = head1.next;
            }

            if (head2 != null) {
                sum += head2.data;
                head2 = head2.next;
            }

            carry = sum / 10;
            temp.next = new Node(sum % 10);
            temp = temp.next;
        }

        // reverse result
        Node result = reverse(dummy.next);

        // 🔥 REMOVE LEADING ZEROS
        while (result != null && result.data == 0 && result.next != null) {
            result = result.next;
        }

        return result;
    }
}
