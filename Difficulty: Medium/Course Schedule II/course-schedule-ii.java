import java.util.*;

class Solution {
    public ArrayList<Integer> findOrder(int n, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build adjacency list
        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);  // y -> x
        }

        // Step 1: Compute indegree of each node
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int neighbor : adj.get(i)) {
                indegree[neighbor]++;
            }
        }

        // Step 2: Add all courses with indegree 0 to queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        ArrayList<Integer> order = new ArrayList<>();

        // Step 3: Process queue
        while (!q.isEmpty()) {
            int course = q.poll();
            order.add(course);

            // Decrease indegree of neighbors
            for (int neighbor : adj.get(course)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0)
                    q.add(neighbor);
            }
        }

        // Step 4: Check if all courses are processed
        if (order.size() == n)
            return order;

        // If not possible to complete all courses
        return new ArrayList<>();
    }
}
