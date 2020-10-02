import java.util.*;

public class BinarySearch {
  private static int search(int[] xs, int a, int lo, int hi) {
    while (lo <= hi) {
      int mid = ((hi - lo) / 2) + lo;
      int guess = xs[mid];
      if (guess == a) return mid;
      if (guess > a) hi = mid - 1;
      if (guess < a) lo = mid + 1;
    }
    return -1;
  }

  public static int search(int[] xs, int a) {
    return search(xs, a, 0, xs.length - 1);
  }

  public static void main(String[] args) {
    int[] xs = { 1, 5, 6, 77, 12, 14, 6, 0};
    Arrays.sort(xs);
    System.out.println(search(xs, 44));
  }
}
