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
//     Node mergeKLists(Node[] arr) {
//         // code here
        
//     }
// }

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

import java.util.PriorityQueue;

class Solution {
    Node mergeKLists(Node[] arr) {
        // Min-Heap to store nodes based on data
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.data - b.data);

        // Insert first node of each list into PQ
        for (Node head : arr) {
            if (head != null) {
                pq.add(head);
            }
        }

        Node dummy = new Node(0); // dummy head
        Node tail = dummy;

        // Process heap until empty
        while (!pq.isEmpty()) {
            Node smallest = pq.poll(); // extract smallest
            tail.next = smallest;
            tail = tail.next;

            if (smallest.next != null) {
                pq.add(smallest.next);
            }
        }

        return dummy.next;
    }
}
