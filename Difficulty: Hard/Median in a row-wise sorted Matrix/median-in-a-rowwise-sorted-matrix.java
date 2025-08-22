import java.util.*;

class Solution {
    public int median(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        
        // Find overall min (first col) and max (last col)
        for (int i = 0; i < n; i++) {
            low = Math.min(low, mat[i][0]);
            high = Math.max(high, mat[i][m - 1]);
        }

        int desired = (n * m + 1) / 2;  // position of median in sorted order

        while (low < high) {
            int mid = (low + high) / 2;

            // Count how many numbers <= mid
            int count = 0;
            for (int i = 0; i < n; i++) {
                count += upperBound(mat[i], mid);
            }

            if (count < desired) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    // Binary search: count of numbers <= target in a row
    private int upperBound(int[] row, int target) {
        int l = 0, r = row.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (row[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
