class Solution {
    int getLongestPrefix(String s) {
        int n = s.length();
        if (n <= 1) return -1; // no non-empty proper prefix possible

        int[] z = computeZ(s);
        for (int m = n - 1; m >= 1; m--) {
            if (z[m] >= n - m) return m;
        }
        return -1;
    }

    private int[] computeZ(String s) {
        int n = s.length();
        int[] z = new int[n];
        z[0] = n;
        int l = 0, r = 0;
        for (int i = 1; i < n; i++) {
            if (i <= r) {
                z[i] = Math.min(r - i + 1, z[i - l]);
            }
            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
                z[i]++;
            }
            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }
        return z;
    }
}
