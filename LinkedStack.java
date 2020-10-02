public class LinkedStack {
  private class Node {
    private int value;
    private Node next;
  }

  Node first;

  public LinkedStack() {
    first = null;
  }


  public void push(int v) {
    Node nd = new Node();
    nd.value = v;
    if (first == null) {
      first = nd;
    } else {
      Node tmp = first;
      first = nd;
      first.next = tmp;
    }
  }

  public int pop() {
    int val = first.value;
    first = first.next;
    return val;
  }
  
  public static void main(String[] args) {
    LinkedStack stack = new LinkedStack();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    System.out.println(stack.pop());
  }
}
