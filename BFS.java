import java.util.*;

public class BFS {
  private Graph Graph;
  private boolean[] visited;
  private int source;
  private int[] edgeTo;
  private LinkedQueue<Integer> q;

  public BFS(Graph g, int src) {
    Graph = g;
    source = src;
    visited = new boolean[g.vcount()];
    edgeTo = new int[g.vcount()];
    q = new LinkedQueue<>();
    search(src);
  }

  // Whereas dfs goes all the way down a single path in
  // a graph, then backs out and goes down another path,
  // bfs visits all adjacent nodes before visiting
  // any nodes beyond them.

  // bfs is good for finding the shortest path from one
  // vertex to another

  // bfs is non-recursive. It works on a visited array and
  // a queue: get adjacent vertices, if they are not visited,
  // add them to the queue. Repeat til the queue is empty.
  // Use a queue rather than a stack because we want FIFO
  // behavior when getting a vertex to visit.
  private void search(int src) {
    q.enq(src);
    while (!q.isEmpty()) {
      int v = q.deq();
      visited[v] = true;
      for (int adj: Graph.getAdjacent(v)) {
        if (!visited[adj]) {
          edgeTo[adj] = v;
          q.enq(adj);
        }
      }
    }
  }

  public boolean isConnected(int v) {
    return visited[v];
  }

  public List<Integer> pathTo(int v) {
    List<Integer> path = new ArrayList<>();
    if (!visited[v]) return path;
    while (v != source) {
      path.add(v);
      v = edgeTo[v];
    }
    path.add(source);
    return path;
  }

  public void printPathTo(int v) {
    List<Integer> path = pathTo(v);
    if (path.size() == 0) {
      System.out.println("No path exists.");
    } else {
      System.out.print("[");
      for (int i = path.size() - 1; i >= 0; i--) {
        System.out.print(" " + path.get(i));
        if (i > 0) {
          System.out.print(" -->");
        }
      }
      System.out.println(" ]");
    }
  }

  public static void main(String[] args) {
    Graph G = new Graph(6, true);
    G.addEdge(0,1);
    G.addEdge(0,2);
    G.addEdge(1, 3);
    G.addEdge(2,3);
    G.addEdge(3,4);
    G.addEdge(4,5);

    BFS bfs = new BFS(G, 0);
    System.out.println(bfs.isConnected(5));
    bfs.printPathTo(5);
  }
}
