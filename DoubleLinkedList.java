public class DoubleLinkedList {
  private class Node {
    int val;
    Node prev;
    Node next;
  }

  Node first;
  Node last;
  int size;

  public DoubleLinkedList() {
    first = null;
    size = 0;
  }

  public void enq(int val) {
    Node node = new Node();
    node.val = val;
    if (first == null) {
      first = node;
      last = first;
    } else {
      Node tmp = first;
      first = node;
      first.next = tmp;
      tmp.prev = first;
    }
    size++;
  }

  public int deq() {
    int val = first.val;
    first = first.next;
    first.prev = null;
    size--;
    return val;
  }

  public int size() {
    return size;
  }

  public static void main(String[] args) {
    DoubleLinkedList dll = new DoubleLinkedList();
    dll.enq(4);
    dll.enq(5);
    dll.enq(6);

    for (Node n = dll.first; n != null; n = n.next) {
      System.out.println(n.val);
    }

    for (Node n = dll.last; n != null; n = n.prev) {
      System.out.println(n.val);
    }
  }
}
