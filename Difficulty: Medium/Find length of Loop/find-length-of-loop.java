/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

// class Solution {
//     public int lengthOfLoop(Node head) {
//         // code here
        
//     }
// }


class Solution {
    public int lengthOfLoop(Node head) {
        if (head == null || head.next == null) return 0;

        Node slow = head, fast = head;

        // Step 1: Detect loop using Floyd’s algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) { // loop detected
                // Step 2: Count loop length
                int count = 1;
                Node temp = slow.next;
                while (temp != slow) {
                    count++;
                    temp = temp.next;
                }
                return count;
            }
        }

        // No loop
        return 0;
    }
}
