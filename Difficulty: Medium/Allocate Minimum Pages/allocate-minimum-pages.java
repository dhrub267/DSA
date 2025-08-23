class Solution {
    public static int findPages(int[] arr, int k) {
        int n = arr.length;
        if (k > n) return -1;  // More students than books, not possible

        int low = 0, high = 0;
        for (int pages : arr) {
            low = Math.max(low, pages); // max element
            high += pages;              // sum of all elements
        }

        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(arr, n, k, mid)) {
                result = mid;   // store possible answer
                high = mid - 1; // try smaller maximum
            } else {
                low = mid + 1;  // increase allowed maximum
            }
        }
        return result;
    }

    // Helper function to check if allocation possible with maxPages limit
    private static boolean isPossible(int[] arr, int n, int k, int maxPages) {
        int studentsRequired = 1;
        int currentSum = 0;

        for (int i = 0; i < n; i++) {
            if (currentSum + arr[i] > maxPages) {
                studentsRequired++;
                currentSum = arr[i];
                if (studentsRequired > k) return false;
            } else {
                currentSum += arr[i];
            }
        }
        return true;
    }

    // Driver
    public static void main(String[] args) {
        int[] arr1 = {12, 34, 67, 90};
        int k1 = 2;
        System.out.println(findPages(arr1, k1)); // Output: 113

        int[] arr2 = {15, 17, 20};
        int k2 = 5;
        System.out.println(findPages(arr2, k2)); // Output: -1
    }
}
