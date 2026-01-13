class Solution {
    public int peakIndexInMountainArray(int[] arr) {

        // first and last element peak nahi ho sakte
        int low = 1;
        int high = arr.length - 2;

        while (low <= high) {
            int mid =(high + low) / 2;

            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;   // peak found
            }
            else if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                low = mid + 1; // peak right side
            }
            else {
                high = mid - 1; // peak left side
            }
        }
        return -1;
    }
}
