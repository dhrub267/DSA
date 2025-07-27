class Solution {
    public static int balanceSums(int[][] mat) {
        int n = mat.length;
        int[] rowSum = new int[n];
        int[] colSum = new int[n];

        // Step 1: Calculate rowSum and colSum
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i] += mat[i][j];
                colSum[j] += mat[i][j];
            }
        }

        // Step 2: Find max among all row and column sums
        int target = 0;
        for (int i = 0; i < n; i++) {
            target = Math.max(target, rowSum[i]);
            target = Math.max(target, colSum[i]);
        }

        // Step 3: Greedily add values to mat[i][j]
        int operations = 0;
        int i = 0, j = 0;

        while (i < n && j < n) {
            int diff = Math.min(target - rowSum[i], target - colSum[j]);
            mat[i][j] += diff;
            rowSum[i] += diff;
            colSum[j] += diff;
            operations += diff;

            if (rowSum[i] == target) i++;
            if (colSum[j] == target) j++;
        }

        return operations;
    }
}
