class Solution {
    public boolean searchMatrix(int[][] mat, int x) {
        int n = mat.length;
        int m = mat[0].length;
        int left = 0, right = n * m - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / m;
            int col = mid % m;
            int midVal = mat[row][col];

            if (midVal == x) return true;

            // Left half is sorted
            int leftRow = left / m, leftCol = left % m;
            int rightRow = right / m, rightCol = right % m;
            int leftVal = mat[leftRow][leftCol];
            int rightVal = mat[rightRow][rightCol];

            if (leftVal <= midVal) {
                if (x >= leftVal && x < midVal) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (x > midVal && x <= rightVal) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
