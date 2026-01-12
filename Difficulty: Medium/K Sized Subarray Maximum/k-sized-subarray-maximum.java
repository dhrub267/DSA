// class Solution {
//     public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
//         // code here
        
//     }
// }


import java.util.*;

class Solution {
    public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {

            // 1. Remove elements out of current window
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // 2. Remove smaller elements from back
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.pollLast();
            }

            // 3. Add current index
            dq.offerLast(i);

            // 4. Add max for current window
            if (i >= k - 1) {
                ans.add(arr[dq.peekFirst()]);
            }
        }

        return ans;
    }
}
