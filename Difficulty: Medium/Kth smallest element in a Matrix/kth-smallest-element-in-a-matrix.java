class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int n = mat.length;

        int low = mat[0][0];
        int high = mat[n-1][n-1];
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int count = countLessEqual(mat, mid);

            if (count < k) {
                low = mid + 1;
            } else {
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }

    // helper function
    private int countLessEqual(int[][] mat, int mid) {
        int n = mat.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int l = 0, r = n - 1;
            while (l <= r) {
                int m = l + (r - l) / 2;
                if (mat[i][m] <= mid) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            count += l; // l = number of elements <= mid
        }
        return count;
    }
}
