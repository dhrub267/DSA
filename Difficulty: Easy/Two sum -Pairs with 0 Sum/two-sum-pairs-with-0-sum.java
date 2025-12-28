// User function Template for Java
import java.util.*;

class Solution {
    public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
        int n = arr.length;

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        // Step 1: sort array
        Arrays.sort(arr);

        int left = 0;
        int right = n - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == 0) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(arr[left]);
                pair.add(arr[right]);
                ans.add(pair);

                // skip duplicates
                int lVal = arr[left];
                int rVal = arr[right];

                while (left < right && arr[left] == lVal) left++;
                while (left < right && arr[right] == rVal) right--;
            }
            else if (sum < 0) {
                left++;
            }
            else {
                right--;
            }
        }

        return ans;
    }
}
