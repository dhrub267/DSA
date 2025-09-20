class Solution {
    public static int longestSubarray(int[] arr) {
        int n = arr.length;
        // sort indices by value
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;
        java.util.Arrays.sort(idx, (a, b) -> Integer.compare(arr[a], arr[b]));

        int[] parent = new int[n];
        int[] size = new int[n];
        boolean[] active = new boolean[n];
        for (int k = 0; k < n; k++) { parent[k] = k; size[k] = 0; active[k] = false; }

        int ans = 0;
        int maxSeg = 0;
        int i = 0;
        while (i < n) {
            int val = arr[idx[i]];
            int j = i;
            // activate all indices with this value
            while (j < n && arr[idx[j]] == val) {
                int pos = idx[j];
                active[pos] = true;
                parent[pos] = pos;
                size[pos] = 1;
                // union with active neighbors
                if (pos - 1 >= 0 && active[pos - 1]) union(pos, pos - 1, parent, size);
                if (pos + 1 < n && active[pos + 1]) union(pos, pos + 1, parent, size);
                int root = find(pos, parent);
                if (size[root] > maxSeg) maxSeg = size[root];
                j++;
            }

            int nextVal = (j < n) ? arr[idx[j]] : Integer.MAX_VALUE;
            // only lengths L up to n matter
            if (val <= n) {
                int intervalHigh = Math.min(nextVal - 1, n);
                int candidate = Math.min(maxSeg, intervalHigh);
                if (candidate >= val) ans = Math.max(ans, candidate);
            }

            i = j;
        }
        return ans;
    }

    private static int find(int x, int[] parent) {
        if (parent[x] != x) parent[x] = find(parent[x], parent);
        return parent[x];
    }

    private static void union(int a, int b, int[] parent, int[] size) {
        int ra = find(a, parent);
        int rb = find(b, parent);
        if (ra == rb) return;
        if (size[ra] < size[rb]) { int t = ra; ra = rb; rb = t; }
        parent[rb] = ra;
        size[ra] += size[rb];
    }
}
