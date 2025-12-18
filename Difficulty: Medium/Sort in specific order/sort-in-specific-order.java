// class Solution {
//     public void sortIt(int[] arr) {
//         // code here
        
//     }
// }


import java.util.*;

class Solution {
    public void sortIt(int[] arr) {
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();

        // Step 1: Separate odd and even
        for (int num : arr) {
            if (num % 2 != 0) {
                odd.add(num);
            } else {
                even.add(num);
            }
        }

        // Step 2: Sort odd descending
        Collections.sort(odd, Collections.reverseOrder());

        // Step 3: Sort even ascending
        Collections.sort(even);

        // Step 4: Merge back to arr
        int index = 0;
        for (int num : odd) {
            arr[index++] = num;
        }
        for (int num : even) {
            arr[index++] = num;
        }
    }
}
