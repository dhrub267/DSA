import java.util.*;

class Solution {
    public int minDifference(String[] arr) {
        int n = arr.length;
        int[] seconds = new int[n];

        for (int i = 0; i < n; i++) {
            seconds[i] = timeToSeconds(arr[i]);
        }

        Arrays.sort(seconds);

        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            minDiff = Math.min(minDiff, seconds[i] - seconds[i - 1]);
        }

        int circularDiff = 86400 - seconds[n - 1] + seconds[0];
        minDiff = Math.min(minDiff, circularDiff);

        return minDiff;
    }

    private int timeToSeconds(String time) {
        String[] parts = time.split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        int s = Integer.parseInt(parts[2]);
        return h * 3600 + m * 60 + s;
    }
}
