// class Solution {
//     public int cntWays(int[] arr) {
//         // code here
        
//     }
// }


class Solution {
    public int cntWays(int[] arr) {
        int n = arr.length;

        int totalEven = 0, totalOdd = 0;

        // Step 1: total even & odd sum
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0)
                totalEven += arr[i];
            else
                totalOdd += arr[i];
        }

        int leftEven = 0, leftOdd = 0;
        int count = 0;

        // Step 2: try removing each index
        for (int i = 0; i < n; i++) {
            int newEven, newOdd;

            if (i % 2 == 0) {
                newEven = leftEven + (totalOdd - leftOdd);
                newOdd  = leftOdd + (totalEven - leftEven - arr[i]);
            } else {
                newEven = leftEven + (totalOdd - leftOdd - arr[i]);
                newOdd  = leftOdd + (totalEven - leftEven);
            }

            if (newEven == newOdd)
                count++;

            // update prefix sums
            if (i % 2 == 0)
                leftEven += arr[i];
            else
                leftOdd += arr[i];
        }

        return count;
    }
}
