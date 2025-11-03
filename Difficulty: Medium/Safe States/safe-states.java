import java.util.*;

class Solution {
    public ArrayList<Integer> safeNodes(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();
        for (int i = 0; i < V; i++) adjRev.add(new ArrayList<>());

        int[] indegree = new int[V];
        
        // Step 1: Reverse the graph
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adjRev.get(v).add(u);
            indegree[u]++;
        }

        // Step 2: Queue with terminal nodes
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        // Step 3: Topo sort style traversal
        ArrayList<Integer> safe = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            safe.add(node);
            for (int neigh : adjRev.get(node)) {
                indegree[neigh]--;
                if (indegree[neigh] == 0) q.add(neigh);
            }
        }

        // Step 4: Sort the result
        Collections.sort(safe);
        return safe;
    }
}
