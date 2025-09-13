import java.util.*;

class Solution {
    public static int minCost(int n, int m, int[] x, int[] y) {
        // Step 1: Sort x[] and y[] in descending order
        Arrays.sort(x);
        Arrays.sort(y);

        // Reverse arrays for descending order
        for (int i = 0; i < x.length / 2; i++) {
            int temp = x[i];
            x[i] = x[x.length - 1 - i];
            x[x.length - 1 - i] = temp;
        }
        for (int i = 0; i < y.length / 2; i++) {
            int temp = y[i];
            y[i] = y[y.length - 1 - i];
            y[y.length - 1 - i] = temp;
        }

        int i = 0, j = 0;
        int horizontalSegments = 1, verticalSegments = 1;
        int cost = 0;

        // Step 2: Pick larger cut cost first
        while (i < x.length && j < y.length) {
            if (x[i] >= y[j]) {
                cost += x[i] * horizontalSegments;
                verticalSegments++;
                i++;
            } else {
                cost += y[j] * verticalSegments;
                horizontalSegments++;
                j++;
            }
        }

        // Step 3: Remaining vertical cuts
        while (i < x.length) {
            cost += x[i] * horizontalSegments;
            verticalSegments++;
            i++;
        }

        // Step 4: Remaining horizontal cuts
        while (j < y.length) {
            cost += y[j] * verticalSegments;
            horizontalSegments++;
            j++;
        }

        return cost;
    }
}
