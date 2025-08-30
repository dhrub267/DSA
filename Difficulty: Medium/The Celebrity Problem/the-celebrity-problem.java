public class Solution {

    // Function to find celebrity
    int celebrity(int mat[][]) {
        int n = mat.length;
        int a = 0, b = n - 1;

        // Step 1: Find candidate
        while (a < b) {
            if (mat[a][b] == 1) {
                a++;
            } else {
                b--;
            }
        }

        int candidate = a;

        // Step 2: Verify candidate
        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                if (mat[candidate][i] == 1) return -1;
                if (mat[i][candidate] == 0) return -1;
            }
        }
        return candidate;
    }

    // Main method
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] mat1 = {
            {1, 1, 0},
            {0, 1, 0},
            {0, 1, 1}
        };
        System.out.println(sol.celebrity(mat1)); // Output: 1

        int[][] mat2 = {
            {1, 1},
            {1, 1}
        };
        System.out.println(sol.celebrity(mat2)); // Output: -1

        int[][] mat3 = {
            {1}
        };
        System.out.println(sol.celebrity(mat3)); // Output: 0
    }
}
