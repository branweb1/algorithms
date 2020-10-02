public class MergeSort {
  private static void merge(int[] xs, int[] aux, int lo, int mid, int hi) {
    int k = lo;
    int origMid = mid;

    // Copy sub-array items into aux array and hook
    // into it with pointers. We can then copy the
    // items in-order back to xs without fear of
    // overwriting anything because it's all in the
    // aux array still
    for (int i = lo; i <= hi; i++) {
      aux[i] = xs[i];
    }

    while (k <= hi) {
      if (lo >= origMid) {
        xs[k++] = aux[mid++];
      } else if (mid > hi) {
        xs[k++] = aux[lo++];
      } else if (aux[lo] < aux[mid]) {
        xs[k++] = aux[lo++];
      } else {
        xs[k++] = aux[mid++];
      }
    }
  }

  // the recursive calls to sort are mainly to split apart array
  // indices for merge.
  // [0,1,2,3]
  // [0,1] [2,3]
  // [0][1] [2][3]
  // The bottom row just returns, doesn't run merge
  // but the 0th and 1st rows do merge their subarrays

  // Useful for understanding runtime. We halve the input at each
  // level, meaning sort call tree will have log base-2 of n levels
  // (starting at 0). We perform n operations at each level (after removeing constants)
  // for a runtime of n*logn
  private static void sort(int[] xs, int[] aux, int lo, int hi) {
    if (hi <= lo) return;
    int mid = ((hi - lo) / 2) + lo;
    sort(xs, aux, lo, mid);
    sort(xs, aux, mid+1, hi);
    merge(xs, aux, lo, mid+1, hi);
  }

  public static void sort(int[] xs) {
    int[] aux = new int[xs.length];
    sort(xs, aux, 0, xs.length - 1);
  }

  public static void main(String[] args) {
    int[] xs = { 3, 2, 1, 8 };
    sort(xs);
    for (int x:xs) {
      System.out.print(x + " ");
    }
    System.out.println("");
  }
}
