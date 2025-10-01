import java.util.*;

class Solution {
    public static ArrayList<ArrayList<Integer>> uniquePerms(int[] arr) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr); // sort for lexicographic order
        boolean[] used = new boolean[arr.length];
        backtrack(arr, new ArrayList<>(), ans, used);
        return ans;
    }

    private static void backtrack(int[] arr, ArrayList<Integer> temp,
                                  ArrayList<ArrayList<Integer>> ans, boolean[] used) {
        if (temp.size() == arr.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (used[i]) continue;

            // Skip duplicates
            if (i > 0 && arr[i] == arr[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            temp.add(arr[i]);

            backtrack(arr, temp, ans, used);

            // backtrack
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }
}
