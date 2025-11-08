class Solution {
    public int numberOfPath(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;
        // 3D DP for memoization
        Integer[][][] dp = new Integer[n][m][k + 1];
        return helper(mat, n, m, 0, 0, k, dp);
    }

    private int helper(int[][] mat, int n, int m, int i, int j, int k, Integer[][][] dp) {
        // Out of bounds
        if (i >= n || j >= m || k < 0) return 0;
        
        // If already computed
        if (dp[i][j][k] != null) return dp[i][j][k];
        
        // If bottom-right cell reached
        if (i == n - 1 && j == m - 1) {
            if (k == mat[i][j]) return 1;
            else return 0;
        }
        
        // Recur for right and down
        int right = helper(mat, n, m, i, j + 1, k - mat[i][j], dp);
        int down = helper(mat, n, m, i + 1, j, k - mat[i][j], dp);
        
        // Store and return result
        return dp[i][j][k] = right + down;
    }
}
