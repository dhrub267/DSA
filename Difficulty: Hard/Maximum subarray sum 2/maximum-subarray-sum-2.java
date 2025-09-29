import java.util.*;

class Solution {
    public int maxSubarrSum(int[] arr, int a, int b) {
        int n = arr.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        long ans = Long.MIN_VALUE;
        Deque<Integer> dq = new ArrayDeque<>();

        for (int r = a; r <= n; r++) {
            // add index r - a (valid left boundary)
            while (!dq.isEmpty() && prefix[dq.peekLast()] >= prefix[r - a]) {
                dq.pollLast();
            }
            dq.addLast(r - a);

            // remove index < r - b
            while (!dq.isEmpty() && dq.peekFirst() < r - b) {
                dq.pollFirst();
            }

            // calculate subarray sum using best left prefix
            if (!dq.isEmpty()) {
                ans = Math.max(ans, prefix[r] - prefix[dq.peekFirst()]);
            }
        }

        return (int) ans;
    }
}
