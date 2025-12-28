import java.util.*;

class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        int n = arr.length;
        ArrayList<Integer> al = new ArrayList<Integer>();

        int i, j;

        for (i = 0; i < n; i++) {
            boolean isLeader = true;   // yahin reset hoga

            for (j = i + 1; j < n; j++) {
                if (arr[i] < arr[j]) {
                    isLeader = false;
                    break;
                }
            }

            if (isLeader == true) {
                al.add(arr[i]);
            }
        }
        return al;
    }
}
