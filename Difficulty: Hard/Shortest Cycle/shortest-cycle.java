import java.util.*;

class Solution {
    public int shortCycle(int V, int[][] edges) {
        // Step 1: Build adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int ans = Integer.MAX_VALUE;

        // Step 2: Run BFS from every vertex
        for (int start = 0; start < V; start++) {
            int[] dist = new int[V];
            Arrays.fill(dist, -1);
            Queue<Integer> q = new LinkedList<>();
            
            q.add(start);
            dist[start] = 0;

            while (!q.isEmpty()) {
                int node = q.poll();

                for (int neigh : adj.get(node)) {
                    if (dist[neigh] == -1) { // Not visited
                        dist[neigh] = dist[node] + 1;
                        q.add(neigh);
                    } 
                    // If already visited and not the immediate parent => cycle found
                    else if (dist[neigh] >= dist[node]) {
                        ans = Math.min(ans, dist[node] + dist[neigh] + 1);
                    }
                }
            }
        }

        // Step 3: Return result
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
}
