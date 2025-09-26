import java.util.*;

class Solution {
    public static void rotateDeque(Deque<Integer> dq, int type, int k) {
        int n = dq.size();
        if (n == 0) return;

        // Effective rotations (no need to rotate more than n times)
        k = k % n;

        if (type == 1) { 
            // Right rotation
            for (int i = 0; i < k; i++) {
                int last = dq.removeLast();
                dq.addFirst(last);
            }
        } else if (type == 2) { 
            // Left rotation
            for (int i = 0; i < k; i++) {
                int first = dq.removeFirst();
                dq.addLast(first);
            }
        }
    }
}
