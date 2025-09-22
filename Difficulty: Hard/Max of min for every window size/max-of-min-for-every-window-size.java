import java.util.*;

class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        int n = arr.length;
        
        // Step 1: Arrays to store indices of PSE and NSE
        int[] left = new int[n];   // Previous smaller
        int[] right = new int[n];  // Next smaller
        
        Arrays.fill(left, -1);
        Arrays.fill(right, n);
        
        Stack<Integer> st = new Stack<>();
        
        // Step 2: Fill Previous Smaller
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                left[i] = st.peek();
            }
            st.push(i);
        }
        
        // Clear stack
        st.clear();
        
        // Step 3: Fill Next Smaller
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                right[i] = st.peek();
            }
            st.push(i);
        }
        
        // Step 4: Result array (for window sizes)
        int[] ans = new int[n + 1];
        Arrays.fill(ans, Integer.MIN_VALUE);
        
        for (int i = 0; i < n; i++) {
            int len = right[i] - left[i] - 1;
            ans[len] = Math.max(ans[len], arr[i]);
        }
        
        // Step 5: Fill remaining values
        for (int i = n - 1; i >= 1; i--) {
            ans[i] = Math.max(ans[i], ans[i + 1]);
        }
        
        // Convert to ArrayList
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            res.add(ans[i]);
        }
        
        return res;
    }
}
