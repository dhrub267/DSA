class Solution {
    public String largestSwap(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        // Last occurrence of each digit
        int[] last = new int[10];
        for (int i = 0; i < n; i++) {
            last[arr[i] - '0'] = i;
        }

        // Traverse left to right
        for (int i = 0; i < n; i++) {
            // Check for bigger digit on right side
            for (int d = 9; d > arr[i] - '0'; d--) {
                if (last[d] > i) {  // bigger digit available on right
                    // Swap
                    char temp = arr[i];
                    arr[i] = arr[last[d]];
                    arr[last[d]] = temp;

                    return new String(arr); // only one swap allowed
                }
            }
        }

        return s; // already largest
    }
}
