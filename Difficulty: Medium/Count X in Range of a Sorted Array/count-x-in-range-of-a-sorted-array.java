// class Solution {
//     public ArrayList<Integer> countXInRange(int[] arr, int[][] queries) {
//         // code here
        
//     }
// }


import java.util.*;

class Solution {

    // lower bound: first index where arr[i] >= x
    private int lowerBound(int[] arr, int x) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < x)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    // upper bound: first index where arr[i] > x
    private int upperBound(int[] arr, int x) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= x)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    public ArrayList<Integer> countXInRange(int[] arr, int[][] queries) {

        ArrayList<Integer> result = new ArrayList<>();

        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            int x = q[2];

            int first = lowerBound(arr, x);
            int last = upperBound(arr, x) - 1;

            int left = Math.max(first, l);
            int right = Math.min(last, r);

            if (left > right)
                result.add(0);
            else
                result.add(right - left + 1);
        }

        return result;
    }
}
