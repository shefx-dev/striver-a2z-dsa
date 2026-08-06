// Problem: Perform DFS traversal of a graph (starting from node 0)

// Brute Force Approach:
// - Use adjacency matrix
// - For each node, scan entire row to find neighbors
// - Recursively visit unvisited neighbors
// - Time Complexity: O(V^2)
// - Space Complexity: O(V)

// Better Approach:
// - Convert edges into adjacency list
// - Use recursion to explore neighbors
// - Time Complexity: O(V + E)
// - Space Complexity: O(V)

// Optimal Approach:
// - Same as Better, but adjacency list is stored efficiently
// - Use visited[] to avoid repeated work
// - Time Complexity: O(V + E)
// - Space Complexity: O(V)

import java.util.*;

class Solution {

    // Brute Force (Adjacency Matrix)
    public List<Integer> brute(int V, List<List<Integer>> edges) {
        int[][] matrix = new int[V][V];

        // Build adjacency matrix
        for (List<Integer> e : edges) {
            int u = e.get(0);
            int v = e.get(1);
            matrix[u][v] = 1;
            matrix[v][u] = 1;
        }

        boolean[] visited = new boolean[V];
        List<Integer> dfs = new ArrayList<>();

        dfsMatrix(0, matrix, visited, dfs);
        return dfs;
    }

    private void dfsMatrix(int node, int[][] matrix, boolean[] visited, List<Integer> dfs) {
        visited[node] = true;
        dfs.add(node);

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[node][i] == 1 && !visited[i]) {
                dfsMatrix(i, matrix, visited, dfs);
            }
        }
    }

    // Better (Adjacency List)
    public List<Integer> better(int V, List<List<Integer>> edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (List<Integer> e : edges) {
            int u = e.get(0);
            int v = e.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[V];
        List<Integer> dfs = new ArrayList<>();

        dfsList(0, adj, visited, dfs);
        return dfs;
    }

    private void dfsList(int node, List<List<Integer>> adj, boolean[] visited, List<Integer> dfs) {
        visited[node] = true;
        dfs.add(node);

        for (int nbr : adj.get(node)) {
            if (!visited[nbr]) {
                dfsList(nbr, adj, visited, dfs);
            }
        }
    }

    // Optimal (Same as Better, but cleaner)
    public List<Integer> optimal(int V, List<List<Integer>> edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (List<Integer> e : edges) {
            adj.get(e.get(0)).add(e.get(1));
            adj.get(e.get(1)).add(e.get(0));
        }

        boolean[] visited = new boolean[V];
        List<Integer> dfs = new ArrayList<>();

        dfsRecursive(0, adj, visited, dfs);
        return dfs;
    }

    private void dfsRecursive(int node, List<List<Integer>> adj, boolean[] visited, List<Integer> dfs) {
        visited[node] = true;
        dfs.add(node);

        for (int nbr : adj.get(node)) {
            if (!visited[nbr]) {
                dfsRecursive(nbr, adj, visited, dfs);
            }
        }
    }

    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();

        int V = 5;
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(0, 1));
        edges.add(Arrays.asList(0, 2));
        edges.add(Arrays.asList(1, 3));
        edges.add(Arrays.asList(2, 4));

        System.out.println("Brute:   " + sol.brute(V, edges));
        System.out.println("Better:  " + sol.better(V, edges));
        System.out.println("Optimal: " + sol.optimal(V, edges));
    }
}
