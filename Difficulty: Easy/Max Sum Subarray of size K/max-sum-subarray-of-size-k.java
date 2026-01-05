// class Solution {
//     public int maxSubarraySum(int[] arr, int k) {
//         // Code here
        
//     }
// }


class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        int n = arr.length;
        
        // sum of first k elements
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        
        int maxSum = windowSum;
        
        // slide the window
        for (int i = k; i < n; i++) {
            windowSum = windowSum + arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        
        return maxSum;
    }
}
