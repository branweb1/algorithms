public class DFS {
  private Graph G;
  private boolean[] visited;

  // Handy for performing topo sort on DAGs
  public DFS(Graph g, int src) {
    G = g;
    visited = new boolean[g.vcount()];
    search(src);
  }

  private void search(int src) {
    visited[src] = true;
    for (int v: G.getAdjacent(src)) {
      if (!visited[v]) {
        search(v);
      }
    }
  }

  public boolean isConnected(int v) {
    return visited[v];
  }

  public static void main(String[] args) {
    Graph G = new Graph(6, true);
    G.addEdge(0,1);
    G.addEdge(0,2);
    G.addEdge(1, 3);
    G.addEdge(2,3);
    G.addEdge(3,4);
    G.addEdge(4,5);

    DFS dfs = new DFS(G, 0);
    System.out.println(dfs.isConnected(5));
  }
}
