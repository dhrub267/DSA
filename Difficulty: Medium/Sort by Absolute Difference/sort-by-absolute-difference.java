import java.util.*;

class Solution {
    public void rearrange(int[] arr, int x) {
        // Convert primitive int[] to Integer[] for stable sorting
        Integer[] temp = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }

        // Sort with custom comparator
        Arrays.sort(temp, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                int diffA = Math.abs(a - x);
                int diffB = Math.abs(b - x);

                // Compare by absolute difference
                return Integer.compare(diffA, diffB);
            }
        });

        // Copy back to original array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
    }
}
