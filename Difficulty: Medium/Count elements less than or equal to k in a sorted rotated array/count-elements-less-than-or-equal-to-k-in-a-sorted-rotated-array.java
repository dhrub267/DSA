// class Solution {
//     public int countLessEqual(int[] arr, int x) {
//         // code here
        
//     }
// }

class Solution {

    public int countLessEqual(int[] arr, int x) {
        int n = arr.length;

        // Step 1: find pivot
        int pivot = findPivot(arr);

        // Step 2: count in both sorted halves
        int count = 0;
        count += countInSorted(arr, 0, pivot - 1, x);
        count += countInSorted(arr, pivot, n - 1, x);

        return count;
    }

    private int findPivot(int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private int countInSorted(int[] arr, int start, int end, int x) {
        if (start > end) return 0;

        int low = start, high = end;
        int ans = start - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= x) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans - start + 1;
    }
}
