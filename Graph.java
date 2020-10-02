import java.util.*;
public class Graph {
  // the idea is just to store integer and map them back to other values
  // so if we were using a directed class to model college course dependency,
  // we could map 0 to calculus, 1 to computer science, etc.
  List<Bag<Integer>> verts;
  boolean directed;
  int vcount;

  public Graph(int capacity) {
    this(capacity, false); // default to undirected
  }

  public Graph(int capacity, boolean _directed) {
    directed = _directed;
    vcount = capacity;
    verts = new ArrayList<>(capacity);
    for (int i = 0; i < capacity; i++) {
      verts.add(i, new Bag<>());
    }
  }

  public void addEdge(int i, int j) {
    verts.get(i).add(j);
    if (!directed) {
      verts.get(j).add(i);
    }
  }

  public Iterable<Integer> getAdjacent(int i) {
    return verts.get(i);
  }

  public int vcount() {
    return vcount;
  }

  public static void main(String[] args) {
    Graph G = new Graph(4, true);
    G.addEdge(0,1);
    G.addEdge(0,2);
    G.addEdge(1, 3);
    G.addEdge(2,3);

    for (int x:G.getAdjacent(3)) {
      System.out.println(x);
    }
  }
}
