import java.util.*;

public class Benchmark {
  private long start;

  public Benchmark() {
    start = System.currentTimeMillis();
  }

  public void reset() {
    start = System.currentTimeMillis();
  }

  public double elapsedTime() {
    return (System.currentTimeMillis() - start) / 1000.0;
  }

  public static void main(String[] args) {
    // int query = Integer.parseInt(args[0]);
    In in = new In(args[0]);
    int size = in.readInt();
    int[] xs = new int[size];
    int[] ys = new int[size];
    StdOut.println("Building array of size " + size);
    for (int i = 0; i < size; i++) {
      xs[i] = (in.readInt());
      ys[i] = xs[i];
    }

    StdOut.println("Sorting array of size " + size);

    Benchmark bm = new Benchmark(); 

    // Selection.sort(xs);
    // StdOut.println("Selection: " + bm.elapsedTime());

    // bm.reset();

    MergeSort.sort(ys);
    StdOut.println("Merge: " + bm.elapsedTime());
    
    // for (int i = xs.length-1; i > xs.length - 101; i--) {
    //   StdOut.println("xs - " + xs[i] + ", ys - " + ys[i]);
    // }

    // StdOut.println("Searching array of size " + size);

    // Benchmark bm = new Benchmark(); 

    // SimpleSearch.search(xs, query);
    // StdOut.println("Simple: " + bm.elapsedTime());

    // Arrays.sort(xs);

    // bm.reset();

    // BinarySearch.search(xs, query);
    // StdOut.println("Binary: " + bm.elapsedTime());
  }
}
