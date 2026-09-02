class Solution {
    ArrayList<Integer> find(int arr[], int k) {

        ArrayList<Integer> ans = new ArrayList<>();

        // First occurrence
        int first = -1;
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (k < arr[mid]) {
                high = mid - 1;
            }
            else if (k > arr[mid]) {
                low = mid + 1;
            }
            else {
                first = mid;
                high = mid - 1;
            }
        }

        // Last occurrence
        int last = -1;
        low = 0;
        high = arr.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (k < arr[mid]) {
                high = mid - 1;
            }
            else if (k > arr[mid]) {
                low = mid + 1;
            }
            else {
                last = mid;
                low = mid + 1;
            }
        }

        // Store first and last occurrence
        ans.add(first);
        ans.add(last);

        return ans;
    }
}