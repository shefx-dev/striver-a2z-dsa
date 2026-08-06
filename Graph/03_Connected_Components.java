// Problem: Count the number of connected components in an undirected graph

// Brute Force Approach (Adjacency Matrix + BFS):
// - Build a VxV adjacency matrix
// - For each unvisited node, run BFS by scanning entire row to find neighbors
// - Each BFS = one connected component
// - Time Complexity: O(V^2)
// - Space Complexity: O(V^2)

// Better Approach (Adjacency List + BFS):
// - Convert edges into adjacency list
// - For each unvisited node, run BFS using queue
// - Each BFS = one connected component
// - Time Complexity: O(V + E)
// - Space Complexity: O(V + E)

// Optimal Approach (Same as Better, but cleaner):
// - Efficient adjacency list
// - BFS only on unvisited nodes
// - Time Complexity: O(V + E)
// - Space Complexity: O(V + E)

import java.util.*;

class Solution {

    // Brute Force (Adjacency Matrix + BFS)
    public int brute(int V, List<List<Integer>> edges) {
        int[][] matrix = new int[V][V];

        // Build adjacency matrix
        for (List<Integer> e : edges) {
            int u = e.get(0);
            int v = e.get(1);
            matrix[u][v] = 1;
            matrix[v][u] = 1;
        }

        boolean[] visited = new boolean[V];
        int components = 0;

        // BFS for each unvisited node
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                components++;

                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                visited[i] = true;

                while (!q.isEmpty()) {
                    int node = q.poll();

                    // Scan entire row to find neighbors
                    for (int nbr = 0; nbr < V; nbr++) {
                        if (matrix[node][nbr] == 1 && !visited[nbr]) {
                            visited[nbr] = true;
                            q.add(nbr);
                        }
                    }
                }
            }
        }

        return components;
    }

    // Better (Adjacency List + BFS)
    public int better(int V, List<List<Integer>> edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // Build adjacency list
        for (List<Integer> e : edges) {
            int u = e.get(0);
            int v = e.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[V];
        int components = 0;

        // BFS for each unvisited node
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                components++;

                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                visited[i] = true;

                while (!q.isEmpty()) {
                    int node = q.poll();

                    for (int nbr : adj.get(node)) {
                        if (!visited[nbr]) {
                            visited[nbr] = true;
                            q.add(nbr);
                        }
                    }
                }
            }
        }

        return components;
    }

    // Optimal (Same as Better, but cleaner)
    public int optimal(int V, List<List<Integer>> edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (List<Integer> e : edges) {
            adj.get(e.get(0)).add(e.get(1));
            adj.get(e.get(1)).add(e.get(0));
        }

        boolean[] visited = new boolean[V];
        int components = 0;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                components++;

                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                visited[i] = true;

                while (!q.isEmpty()) {
                    int node = q.poll();

                    for (int nbr : adj.get(node)) {
                        if (!visited[nbr]) {
                            visited[nbr] = true;
                            q.add(nbr);
                        }
                    }
                }
            }
        }

        return components;
    }

    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();

        int V1 = 4;
        List<List<Integer>> edges1 = new ArrayList<>();
        edges1.add(Arrays.asList(0, 1));
        edges1.add(Arrays.asList(1, 2));

        System.out.println("Brute:   " + sol.brute(V1, edges1));   // 2
        System.out.println("Better:  " + sol.better(V1, edges1));  // 2
        System.out.println("Optimal: " + sol.optimal(V1, edges1)); // 2

        int V2 = 7;
        List<List<Integer>> edges2 = new ArrayList<>();
        edges2.add(Arrays.asList(0, 1));
        edges2.add(Arrays.asList(1, 2));
        edges2.add(Arrays.asList(2, 3));
        edges2.add(Arrays.asList(4, 5));

        System.out.println("Brute:   " + sol.brute(V2, edges2));   // 3
        System.out.println("Better:  " + sol.better(V2, edges2));  // 3
        System.out.println("Optimal: " + sol.optimal(V2, edges2)); // 3
    }
}
