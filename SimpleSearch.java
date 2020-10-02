import java.util.*;

public class SimpleSearch {
  public static int search(int[] xs, int a) {
    for (int i = 0; i < xs.length; i++) {
      if (xs[i] == a) return i;
    }
    return -1;
  }
}
