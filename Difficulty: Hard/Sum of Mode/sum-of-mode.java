import java.util.*;

class Solution {
    public int sumOfModes(int[] arr, int k) {
        int n = arr.length;
        Map<Integer, Integer> freq = new HashMap<>();
        
        // TreeSet to store {frequency, element}, sorted by (freq desc, element asc)
        TreeSet<int[]> set = new TreeSet<>((a, b) -> {
            if (a[0] != b[0]) return b[0] - a[0]; // higher frequency first
            return a[1] - b[1]; // smaller element first
        });

        int sum = 0;

        // initialize first window
        for (int i = 0; i < k; i++) {
            int val = arr[i];
            if (freq.containsKey(val)) {
                int old = freq.get(val);
                set.remove(new int[]{old, val});
                freq.put(val, old + 1);
                set.add(new int[]{old + 1, val});
            } else {
                freq.put(val, 1);
                set.add(new int[]{1, val});
            }
        }

        // add mode of first window
        sum += set.first()[1];

        // slide the window
        for (int i = k; i < n; i++) {
            int in = arr[i], out = arr[i - k];

            // remove outgoing element
            int oldOut = freq.get(out);
            set.remove(new int[]{oldOut, out});
            if (oldOut == 1) {
                freq.remove(out);
            } else {
                freq.put(out, oldOut - 1);
                set.add(new int[]{oldOut - 1, out});
            }

            // add incoming element
            if (freq.containsKey(in)) {
                int oldIn = freq.get(in);
                set.remove(new int[]{oldIn, in});
                freq.put(in, oldIn + 1);
                set.add(new int[]{oldIn + 1, in});
            } else {
                freq.put(in, 1);
                set.add(new int[]{1, in});
            }

            // add mode
            sum += set.first()[1];
        }

        return sum;
    }
}
