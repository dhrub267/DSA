import java.util.*;

class Solution {
    public int diameter(int V, int[][] edges) {
        // Create adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        // First BFS to find farthest node from 0
        int farNode = bfs(graph, 0, V)[0];
        
        // Second BFS from farthest node to get diameter
        int diameter = bfs(graph, farNode, V)[1];
        
        return diameter;
    }
    
    private int[] bfs(List<List<Integer>> graph, int start, int V) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[V];
        int[] dist = new int[V];
        
        q.add(start);
        visited[start] = true;
        
        int farNode = start;
        
        while(!q.isEmpty()) {
            int node = q.poll();
            
            for(int nbr : graph.get(node)) {
                if(!visited[nbr]) {
                    visited[nbr] = true;
                    dist[nbr] = dist[node] + 1;
                    q.add(nbr);
                    
                    if(dist[nbr] > dist[farNode]) {
                        farNode = nbr;
                    }
                }
            }
        }
        
        return new int[]{farNode, dist[farNode]};
    }
}
