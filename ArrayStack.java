public class ArrayStack {
  ResizeArray<Integer> items;

  public ArrayStack() {
    items = new ResizeArray<>();
  }

  public void push(int v) {
    items.push(v);
  }

  public int pop() {
    return items.pop();
  }

  public static void main(String[] args) {
    ArrayStack arr = new ArrayStack();
    arr.push(1);
    arr.push(2);
    System.out.println(arr.pop());
  }
}
