import java.util.*;

class Solution {
    public ArrayList<Integer> nextGreater(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>(Collections.nCopies(n, -1));
        Stack<Integer> st = new Stack<>();

        // traverse array twice (circular)
        for (int i = 0; i < 2 * n; i++) {
            int num = arr[i % n];

            // check stack top
            while (!st.isEmpty() && arr[st.peek()] < num) {
                res.set(st.pop(), num);
            }

            // only push index in first pass
            if (i < n) {
                st.push(i);
            }
        }

        return res;
    }
}
