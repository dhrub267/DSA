class Solution {

    // --------- Quick Sort ----------
    void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // --------- Subset Logic ----------
    public boolean isSubset(int a[], int b[]) {
        int n = a.length;
        int m = b.length;

        // manual sort
        quickSort(a, 0, n - 1);
        quickSort(b, 0, m - 1);

        int i = 0, j = 0;

        while (i < n && j < m) {
            if (a[i] == b[j]) {
                i++;
                j++;
            } else if (a[i] < b[j]) {
                i++;
            } else {
                return false;
            }
        }

        return j == m;
    }
}
