package BreadthFirst;

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Arrays;

class BFSTraversal {

    static class Graph {

        Integer nodes;
        List<List<Integer>> adjlist;
        boolean[] visited;

        Graph (int arg_nodes) {
            nodes = arg_nodes;
            adjlist = new ArrayList<>(nodes);
            for (int i=0; i<nodes; i++)
                adjlist.add(new ArrayList<>());
            visited = new boolean[nodes];
        }

        void AddEdge (int src, int dst) {
            adjlist.get(src).add(dst);
            adjlist.get(dst).add(src);
        }

        // BFS implementation
        void BFS (int src) {

            Queue<Integer> Q = new LinkedList<>();    // Breadth First uses a Queue to evenly 
            Q.add(src);                               // search all adjacent nodes of a root node
            System.out.print(src + " ");              // by queueing them and then assigning the next root node
            visited[src] = true;                      // and queuing any new adjacent 
                                                      // nodes while ignoring already visited nodes.
            while (!Q.isEmpty()) {                    // Good for shortest path and peer to peer networks.

                src = Q.peek();
                Q.remove();

                for (int adj_node : adjlist.get(src)) {

                    if (!visited[adj_node]) {
                        Q.add(adj_node);
                        System.out.print(adj_node + " ");
                        visited[adj_node] = true;
                    }
                }
            }
            // Mark nodes unvisited for next traversal
            Arrays.fill(visited, false);
        }
    }

    public static void main (String[] args) {

        Graph g = new Graph(7);

        g.AddEdge(0,1);               
        g.AddEdge(0,2);
        g.AddEdge(1,3);
        g.AddEdge(1,4);
        g.AddEdge(2,3);
        g.AddEdge(3,5);
        g.AddEdge(4,6);
        g.AddEdge(5,6);

        System.out.println("BFS Graph Traversal ");
        System.out.print("\nSource Node (0): "); g.BFS(0);
        System.out.print("\nSource Node (3): "); g.BFS(3);

        Graph t = new Graph(10);

        t.AddEdge(0,1);
        t.AddEdge(0,2);
        t.AddEdge(0,3);
        t.AddEdge(1,4);
        t.AddEdge(1,5);
        t.AddEdge(1,6);
        t.AddEdge(3,7);
        t.AddEdge(3,8);
        t.AddEdge(4,9);

        System.out.println("\n\nBFS Tree Traversal");
        System.out.print("\nRoot Node (0): "); t.BFS(0);
        System.out.print("\nRoot Node (9): "); t.BFS(9);
    }
}