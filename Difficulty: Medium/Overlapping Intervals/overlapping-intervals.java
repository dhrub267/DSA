// class Solution {
//     public ArrayList<int[]> mergeOverlap(int[][] arr) {
//         // Code here
        
//     }
// }


import java.util.*;

class Solution {
    public ArrayList<int[]> mergeOverlap(int[][] arr) {
        
        ArrayList<int[]> ans = new ArrayList<>();

        // edge case
        if (arr.length == 0) return ans;

        // 1️⃣ sort by start time
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        // 2️⃣ first interval add
        int start = arr[0][0];
        int end = arr[0][1];

        // 3️⃣ loop
        for (int i = 1; i < arr.length; i++) {

            // overlap case
            if (arr[i][0] <= end) {
                end = Math.max(end, arr[i][1]);
            } 
            // no overlap
            else {
                ans.add(new int[]{start, end});
                start = arr[i][0];
                end = arr[i][1];
            }
        }

        // last interval add
        ans.add(new int[]{start, end});

        return ans;
    }
}
