import java.util.*;

class Solution {
    static int maxArea(int mat[][]) {
        int n = mat.length;
        int m = mat[0].length;
        
        int[] height = new int[m];
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            // update histogram heights
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    height[j] = 0;
                } else {
                    height[j] += 1;
                }
            }

            // calculate largest rectangle area for this row
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j <= m; j++) {
                int h = (j == m) ? 0 : height[j];
                while (!stack.isEmpty() && h < height[stack.peek()]) {
                    int heightTop = height[stack.pop()];
                    int width = stack.isEmpty() ? j : j - stack.peek() - 1;
                    maxArea = Math.max(maxArea, heightTop * width);
                }
                stack.push(j);
            }
        }

        return maxArea;
    }
}
