public class ResizeArray<A> {
  A[] items;
  int idx;

  public ResizeArray() {
    // casting hack becase java can't initialze
    // generic arrays
    items = (A[]) new Object[1];
    idx = 0;
  }
  
  public void push(A item) {
    items[idx++] = item;
    // if full, double in size
    if (idx >= items.length) {
      resize(items.length*2);
    }
  }

  public A pop() {
    A val = items[--idx];
    items[idx] = null;
    // if 1/4 full, cut in half. It's 1/4, 1/2 to avoid thrashing.
    // Imagine we cut in half when half full, then pushed and popped
    // { 1,2,3,_,_,_ } - pop
    // { 1,2,_,_,_,_ } - resize down
    // { 1,2,_ } - push
    // { 1,2,3 } - resize up
    // { 1,2,3, _, _, _} - pop
    // { 1,2,_,_,_,_ } - resize down
    // If we keep pushing and popping, we'll keep resizing up and down,
    // which has a linear runtime. Not good
    if (idx <= items.length/4) {
      resize(items.length/2);
    }
    return val;
  }

  private void resize(int capacity) {
    A[] resized = (A[]) new Object[capacity];
    for (int i = 0; i < idx; i++) {
      resized[i] = items[i];
    }
    items = resized;
  }

  public int size() {
    return items.length;
  }

  public static void main(String[] args) {
    ResizeArray<Integer> arr = new ResizeArray<>();
    arr.push(1);
    arr.push(2);
    arr.push(3); 
    System.out.println(arr.size()); //8
    arr.pop();
    System.out.println(arr.size()); //4
  } 
}
