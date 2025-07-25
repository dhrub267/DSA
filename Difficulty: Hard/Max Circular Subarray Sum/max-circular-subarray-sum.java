class Solution {
    public int maxCircularSum(int[] arr) {
        int n = arr.length;
        int maxNormal = kadane(arr);

        if (maxNormal < 0)
            return maxNormal;

        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
            arr[i] = -arr[i]; // Invert for min subarray
        }

        int maxInverted = kadane(arr); // Gives -min subarray
        int maxCircular = totalSum + maxInverted;

        return Math.max(maxNormal, maxCircular);
    }

    // Helper method (can remain static or not based on GFG platform)
    private int kadane(int[] arr) {
        int maxEndingHere = arr[0];
        int maxSoFar = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }
}
