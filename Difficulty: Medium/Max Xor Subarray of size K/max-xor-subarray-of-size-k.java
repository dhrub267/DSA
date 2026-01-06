// class Solution {
//     public int maxSubarrayXOR(int[] arr, int k) {
//         // code here
        
//     }
// }


class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        int n = arr.length;

        // XOR of first window
        int currXor = 0;
        for (int i = 0; i < k; i++) {
            currXor ^= arr[i];
        }

        int maxXor = currXor;

        // Slide the window
        for (int i = k; i < n; i++) {
            currXor ^= arr[i - k]; // remove left element
            currXor ^= arr[i];     // add right element

            if (currXor > maxXor) {
                maxXor = currXor;
            }
        }

        return maxXor;
    }
}

