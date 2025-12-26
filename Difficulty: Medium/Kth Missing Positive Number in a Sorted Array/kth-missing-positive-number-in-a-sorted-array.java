// class Solution {
//     public int kthMissing(int[] arr, int k) {
//         // code here
        
//     }
// }


class Solution {
    public int kthMissing(int[] arr, int k) {
        int n = arr.length;
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // missing numbers till mid
            int missing = arr[mid] - (mid + 1);

            if (missing < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // kth missing number
        return left + k;
    }
}
