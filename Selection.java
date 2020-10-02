public class Selection {
  private static void swap(int[] xs, int i, int j) {
    int tmp = xs[i];
    xs[i] = xs[j];
    xs[j] = tmp;
  }

  public static void sort(int[] xs) {
    for (int i = 0; i < xs.length; i++) {
      for (int j = i + 1; j < xs.length; j++) {
        if (xs[i] > xs[j]) swap(xs, i, j);
      }
    }
  }

  public static void main(String[] args) {
    int[] xs = { 4, 2, 7, 1, 3 };
    sort(xs);
    for (int x: xs) {
      System.out.print(x + " ");
    }
    System.out.println("");
  }
}
