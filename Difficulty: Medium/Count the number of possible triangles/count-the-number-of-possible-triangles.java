import java.util.*;

class Solution {
    public int countTriangles(int arr[]) {
        int n = arr.length;
        Arrays.sort(arr);
        int count = 0;

        // Fix the largest element one by one
        for (int k = n - 1; k >= 2; k--) {
            int i = 0, j = k - 1;
            
            while (i < j) {
                if (arr[i] + arr[j] > arr[k]) {
                    // All elements between i and j-1 with j will form valid triangles
                    count += (j - i);
                    j--;  // move left
                } else {
                    i++;  // need bigger sum
                }
            }
        }
        return count;
    }
}
